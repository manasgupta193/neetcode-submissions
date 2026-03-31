class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;

        // One loop to rule them all
        // We continue as long as at least one string has characters left
        while (i < n1 || i < n2) {
            if (i < n1) {
                result.append(word1.charAt(i));
            }
            if (i < n2) {
                result.append(word2.charAt(i));
            }
            i++;
        }

        return result.toString();
    }
}