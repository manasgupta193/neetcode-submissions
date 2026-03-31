class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // We compare: 
                // 1. Current dp[i]
                // 2. Breaking i into exactly j and (i-j)
                // 3. Breaking i into j and the best break of (i-j)
                int currentMax = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], currentMax);
            }
        }
        return dp[n];
    }
}