class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);

        Map<Character, Integer> windowMap = new HashMap<>();
        int have = 0, need = targetMap.size();
        int[] res = {-1, -1}; // Store [start, end]
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))) {
                have++;
            }

            // While window is valid, try to shrink it
            while (have == need) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}