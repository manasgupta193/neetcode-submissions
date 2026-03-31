class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n < m) return minDistance(word2, word1);

        int[] dp = new int[m + 1];
        for (int j = 0; j <= m; j++) dp[j] = j;

        for (int i = 1; i <= n; i++) {
            int prevDiagonal = dp[0];
            dp[0] = i;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevDiagonal;
                } else {
                    dp[j] = 1 + Math.min(prevDiagonal, Math.min(dp[j], dp[j - 1]));
                }
                prevDiagonal = temp;
            }
        }
        return dp[m];
    }
}