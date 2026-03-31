class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Convert list to set for O(1) lookups
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int level = 1;

        // 2. BFS Traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process current level
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level;

                char[] chars = currWord.toCharArray();
                // Try changing every character position
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = String.valueOf(chars);
                        
                        if (dict.contains(nextWord)) {
                            queue.add(nextWord);
                            dict.remove(nextWord); // Mark as visited to avoid cycles
                        }
                    }
                    chars[j] = originalChar; // Backtrack character
                }
            }
            level++;
        }
        
        return 0;
    }
}