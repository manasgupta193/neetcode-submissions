class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        // dp[i] = min extra characters in substring s[i...n-1]
        int[] dp = new int[n + 1];

        // Base case: end of string has 0 extra chars
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Default choice: treat s[i] as an extra character
            dp[i] = dp[i + 1] + 1;

            // Try all possible words starting at index i
            for (int j = i + 1; j <= n; j++) {
                if (dict.contains(s.substring(i, j))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[0];
    }
}