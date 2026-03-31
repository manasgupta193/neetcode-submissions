class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // n nodes labeled 1 to n
        int[] parent = new int[n + 1];
        
        // Initialize: each node is its own parent (its own set)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            
            // If they share the same root, they are already connected.
            // Adding this edge creates a cycle!
            if (rootU == rootV) {
                return edge;
            }
            
            // Otherwise, union them (connect the sets)
            parent[rootU] = rootV;
        }
        
        return new int[0];
    }
    
    // Find with Path Compression
    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        // Optimization: point current node directly to the root
        return parent[i] = find(parent, parent[i]);
    }
}