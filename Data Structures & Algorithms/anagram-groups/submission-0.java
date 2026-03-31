class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Create a frequency array for the current string.
            // Size 26 for lowercase English letters.
            int[] charCounts = new int[26];
            for (char c : str.toCharArray()) {
                charCounts[c - 'a']++;
            }

            // Build a unique key from the frequency array.
            // Example: "aab" -> counts = [2,1,0,...0] -> key = "#2#1#0..."
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append("#").append(charCounts[i]); // Prefix with '#' to separate counts
            }
            String key = keyBuilder.toString();

            // Same logic as before: group using the generated key.
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }
            anagramGroups.get(key).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
