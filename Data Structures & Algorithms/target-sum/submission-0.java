class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        
        int s2 = (sum + target) / 2;
        int[] dp = new int[s2 + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = s2; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[s2];
    }
}