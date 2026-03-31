class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build Adjacency List
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) adj[f[0]].add(new int[]{f[1], f[2]});

        // 2. dist[i][j] = min cost to reach city i with j stops
        // Since we allow k stops, we have up to k+1 edges.
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // PriorityQueue: {cost, city, edges_used}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int edges = curr[2];

            // If we reached destination, because it's a Min-Heap, 
            // the first time we pull 'dst' it IS the cheapest valid path.
            if (u == dst) return cost;

            // If we can still take more stops (edges used < k + 1)
            if (edges <= k) {
                for (int[] next : adj[u]) {
                    int v = next[0];
                    int weight = next[1];
                    
                    // Relaxation: if this path is cheaper than any 
                    // previous path to 'v' with this specific number of edges
                    if (cost + weight < dist[v][edges + 1]) {
                        dist[v][edges + 1] = cost + weight;
                        pq.offer(new int[]{dist[v][edges + 1], v, edges + 1});
                    }
                }
            }
        }

        return -1;
    }
}