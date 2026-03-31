class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] counts = new int[26];
        int maxFreq = 0;
        char maxChar = ' ';
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] > maxFreq) {
                maxFreq = counts[c - 'a'];
                maxChar = c;
            }
        }

        if (maxFreq > (n + 1) / 2) return "";

        char[] res = new char[n];
        int index = 0;

        // Place the most frequent character first at even indices
        while (counts[maxChar - 'a'] > 0) {
            res[index] = maxChar;
            index += 2;
            counts[maxChar - 'a']--;
        }

        // Fill the rest
        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (index >= n) index = 1; // Switch to odd indices
                res[index] = (char) (i + 'a');
                index += 2;
                counts[i]--;
            }
        }

        return String.valueOf(res);
    }
}