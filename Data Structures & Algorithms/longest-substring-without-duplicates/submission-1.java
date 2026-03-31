class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map stores the character and its next immediate index
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                // Jump 'left' to the right of the previous occurrence
                // Math.max ensures 'left' never moves backward
                left = Math.max(map.get(current), left);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(current, right + 1);
        }
        return maxLen;
    }
}