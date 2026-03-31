class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int s : stones) totalSum += s;
        
        int target = totalSum / 2;
        // dp[i] will be true if a sum of i can be reached
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int stone : stones) {
            // Iterate backwards to ensure each stone is used only once
            for (int i = target; i >= stone; i--) {
                if (dp[i - stone]) {
                    dp[i] = true;
                }
            }
        }
        
        // Find the largest sum 's1' that is <= totalSum / 2
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                // The two groups are 'i' and 'totalSum - i'
                // The difference is (totalSum - i) - i
                return totalSum - 2 * i;
            }
        }
        
        return 0;
    }
}