class Solution {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return solve(s, wordSet);
    }

    private List<String> solve(String s, Set<String> wordSet) {
        // If we've seen this substring before, return the cached sentences
        if (memo.containsKey(s)) return memo.get(s);
        
        List<String> res = new ArrayList<>();
        // Base case: we reached the end of the string
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixWays = solve(s.substring(i), wordSet);
                for (String suffix : suffixWays) {
                    res.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }
        
        memo.put(s, res);
        return res;
    }
}