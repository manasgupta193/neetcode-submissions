class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string is breakable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0...j] is valid and s[j...i] is a word, then s[0...i] is valid
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check other j's for this i
                }
            }
        }
        return dp[s.length()];
    }
}