class Solution {
    public boolean isMatch(String s, String p) {
        int sn = s.length(), pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[sn][pn] = true;

        for (int i = sn; i >= 0; i--) {
            for (int j = pn - 1; j >= 0; j--) {
                boolean firstMatch = (i < sn && 
                                     (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                
                if (j + 1 < pn && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}