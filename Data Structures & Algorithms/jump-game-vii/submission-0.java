class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        // reachableCount tracks how many 'true' dp values are in the 
        // range [i - maxJump, i - minJump]
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            // 1. Add the new potential jump source to the window
            if (i >= minJump && dp[i - minJump]) {
                reachableCount++;
            }
            
            // 2. Remove the jump source that is now too far away
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            // 3. If there's at least one reachable '0' in our window,
            // and the current spot is a '0', then this spot is reachable.
            if (reachableCount > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}