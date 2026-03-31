class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // 1. Create a rank map for the alien alphabet
        int[] alienOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alienOrder[order.charAt(i) - 'a'] = i;
        }

        // 2. Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i+1], alienOrder)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] alienOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            
            if (c1 != c2) {
                // If characters differ, check their alien ranks
                return alienOrder[c1 - 'a'] < alienOrder[c2 - 'a'];
            }
        }
        
        // If we reach here, one word is a prefix of the other.
        // The shorter word must come first.
        return len1 <= len2;
    }
}