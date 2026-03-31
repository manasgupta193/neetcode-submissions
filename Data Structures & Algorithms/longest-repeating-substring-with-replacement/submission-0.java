class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] charCounts = new int[26]; // Frequency map for characters 'A' through 'Z'
        int left = 0;
        int maxFrequency = 0; // Stores the max frequency of any character in the current window
        int maxLength = 0;    // Stores the overall maximum valid window length

        // Iterate with the right pointer to expand the window
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // Increment count for the current character and update maxFrequency
            charCounts[currentChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, charCounts[currentChar - 'A']);

            // Calculate the number of replacements needed for the current window
            // windowLength - maxFrequency = number of characters that are NOT the most frequent one
            int replacementsNeeded = (right - left + 1) - maxFrequency;

            // If replacements needed exceed 'k', shrink the window from the left
            if (replacementsNeeded > k) {
                // Decrement the count of the character at the 'left' pointer
                charCounts[s.charAt(left) - 'A']--;
                // Move the left pointer to shrink the window
                left++;
                // Note: maxFrequency doesn't need to be recalculated downward.
                // It will only be updated if a new max frequency is found by expanding right.
            }
            
            // The current window (after potential shrinking) is valid.
            // Update maxLength with the current valid window length.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}