class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (single char center)
            totalCount += expand(s, i, i);
            // Even length palindromes (gap center)
            totalCount += expand(s, i, i + 1);
        }
        return totalCount;
    }

    private int expand(String s, int L, int R) {
        int count = 0;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            count++;
            L--;
            R++;
        }
        return count;
    }
}