class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            counts[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(right) - 'A']);

            // If window size - maxFreq > k, the window is invalid
            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't strictly need to update maxFreq here 
                // because a smaller maxFreq won't give us a better maxLen
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}