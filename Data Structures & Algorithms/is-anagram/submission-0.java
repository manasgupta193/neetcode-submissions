class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Check if lengths are different. If so, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Use an array to store character frequencies.
        // Since strings consist of lowercase English letters, an array of size 26 is sufficient.
        // 'a' corresponds to index 0, 'b' to 1, ..., 'z' to 25.
        int[] charCounts = new int[26];

        // Step 3: Iterate through string 's' and increment counts for its characters.
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++; // 'a' - 'a' = 0, 'b' - 'a' = 1, etc.
        }

        // Step 4: Iterate through string 't' and decrement counts for its characters.
        // If 't' is an anagram of 's', then after this loop, all counts should be zero.
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--; // Decrement count
            // Optimization: If a count goes negative, it means 't' has more of a certain character
            // than 's', so it cannot be an anagram. We can return false early.
            if (charCounts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // Step 5: After both loops, all counts in charCounts array must be zero.
        // If any count is non-zero, it means 's' and 't' do not have the same character frequencies.
        // (Note: The optimization in Step 4 already handles the 't' having more' case.
        // This final check ensures 's' didn't have characters 't' didn't have enough of.)
        // However, given the initial length check and the optimization, this final loop
        // for `charCounts` is technically redundant but good for conceptual understanding.
        // If lengths are equal and we never went negative, all counts *must* be zero.
        /*
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        */

        // If we reach here, it means they are anagrams.
        return true;
    }
}