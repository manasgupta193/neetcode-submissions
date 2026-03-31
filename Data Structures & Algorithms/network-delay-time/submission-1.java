class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build Adjacency List: Map<Source, List<[Neighbor, Weight]>>
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 2. Distance array to store the minimum time to reach each node
        // Initialize with infinity, except for the source node k
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        // 3. Priority Queue: Store [Node, TimeReceived]
        // Min-heap sorted by TimeReceived ensures we always process the earliest arrival
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int time = curr[1];

            // If we found a faster way to reach node u already, skip this entry
            if (time > minTime[u]) continue;

            // Check all outgoing connections from current node u
            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int travelTime = neighbor[1];

                    // Relaxation: If reaching v through u is faster than its current minTime
                    if (minTime[u] + travelTime < minTime[v]) {
                        minTime[v] = minTime[u] + travelTime;
                        pq.offer(new int[]{v, minTime[v]});
                    }
                }
            }
        }

        // 4. Calculate final answer
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            // If any node is still at infinity, it means it's unreachable
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, minTime[i]);
        }

        return maxDelay;
    }
}