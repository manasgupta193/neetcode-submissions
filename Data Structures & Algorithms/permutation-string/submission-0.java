class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false; // s1 cannot be a permutation of a substring in s2 if s1 is longer
        }

        int[] s1Freq = new int[26]; // Frequency map for characters in s1
        int[] windowFreq = new int[26]; // Frequency map for characters in the current window of s2

        // 1. Populate frequency maps for s1 and the initial window of s2 (first n1 characters)
        for (int i = 0; i < n1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // 2. Check if the initial window is a permutation
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // 3. Slide the window
        // 'left' pointer starts at 0 and moves. 'right' pointer starts at n1 and moves.
        // The window always has a fixed size of n1.
        for (int right = n1; right < n2; right++) {
            // Add the new character entering the window from the right
            windowFreq[s2.charAt(right) - 'a']++;
            
            // Remove the character leaving the window from the left
            // The character leaving is at index (right - n1)
            windowFreq[s2.charAt(right - n1) - 'a']--;

            // Check if the current window is a permutation
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        // If no permutation found after checking all windows
        return false;
    }
}