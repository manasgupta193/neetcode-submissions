class Solution {
    public String foreignDictionary(String[] words) {
        // 1. Initialize data structures
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // 2. Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            // Check for prefix edge case
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {
                    if (!adj.get(parent).contains(child)) {
                        adj.get(parent).add(child);
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    break; // Only the first differing character matters
                }
            }
        }

        // 3. BFS (Kahn's Algorithm)
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.offer(c);
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            for (char neighbor : adj.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }

        // 4. Check for cycles (if result length != total unique characters)
        return sb.length() == inDegree.size() ? sb.toString() : "";
    }
}