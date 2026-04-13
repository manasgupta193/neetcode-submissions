class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] is the max lead Alex has over Lee in piles[i...j]
        int[][] dp = new int[n][n];
        
        // Base case: only one pile left
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        
        // Fill the table for lengths 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // Current player takes i OR j, then subtracts the lead the next player gets
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][n - 1] > 0;
    }
}