class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Base case: 1 or 2 nodes are already their own centers
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }

        // 1. Build Adjacency List and track degrees
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        int[] degree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // 2. Initialize Queue with all current leaf nodes
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) leaves.add(i);
        }

        // 3. Trim leaves level-by-level until 2 or fewer remain
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leafCount = leaves.size();
            remainingNodes -= leafCount;
            for (int i = 0; i < leafCount; i++) {
                int leaf = leaves.poll();
                // Find the neighbor of this leaf to reduce its degree
                for (int neighbor : adj.get(leaf)) {
                    adj.get(neighbor).remove(leaf);
                    if (--degree[neighbor] == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }

        // The remaining nodes in the queue are the centers
        return new ArrayList<>(leaves);
    }
}