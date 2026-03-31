class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0; // Empty string has 0 length
        }

        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        // HashMap to store the last seen index of each character
        // Key: character, Value: index
        Map<Character, Integer> charIndexMap = new HashMap<>();

        // Right pointer iterates through the string
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If the current character is already in the map AND
            // its last seen index is greater than or equal to the current 'left' pointer,
            // it means we have found a duplicate WITHIN our current window.
            // We need to move the 'left' pointer to one position past the previous occurrence
            // of the duplicate character.
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }

            // Update the last seen index of the current character.
            // This is crucial even if it's a duplicate (newest index).
            charIndexMap.put(currentChar, right);

            // Calculate the current window's length (right - left + 1)
            // and update the overall maximum length found.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}