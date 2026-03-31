class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int requiredMatches = tFreq.size(); // Number of distinct chars in t
        int currentMatches = 0;             // Number of distinct chars in window with >= t's frequency
        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Expand the window and update its frequency map
            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

            // Check if this character helps satisfy a requirement
            if (tFreq.containsKey(currentChar) && windowFreq.get(currentChar).intValue() == tFreq.get(currentChar).intValue()) {
                currentMatches++;
            }

            // A valid window is found. Now try to shrink it from the left.
            while (currentMatches == requiredMatches) {
                // Update the minimum window size if the current one is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                // Shrink the window by moving the left pointer
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // If removing this character causes a requirement to be unmet,
                // decrement the match count.
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    currentMatches--;
                }
                
                left++; // Move the left pointer
            }
        }

        // If minLength was never updated, no valid window was found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}