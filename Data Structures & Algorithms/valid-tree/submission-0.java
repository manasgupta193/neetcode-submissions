class Solution {
    class UnionFind {
        int[] parent;
        int count; // Number of connected components

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            count = n;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
                return true;
            }
            return false; // They are already connected; this edge creates a cycle
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            // If union returns false, a cycle was detected
            if (!uf.union(edge[0], edge[1])) return false;
        }

        // If we have n-1 edges and no cycles, it's a valid tree
        return true;
    }
}