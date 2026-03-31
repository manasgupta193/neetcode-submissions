class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build Adjacency List: Source -> List of {Target, Weight}
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 2. PriorityQueue to store {currentTime, node}
        // Min-heap based on currentTime
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // 3. Distance map to keep track of shortest time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            // If we've already found a shorter path to this node, skip it
            if (dist.containsKey(node)) continue;
            dist.put(node, d);

            if (adj.containsKey(node)) {
                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{d + weight, nextNode});
                    }
                }
            }
        }

        // 4. Result check
        if (dist.size() != n) return -1;
        
        int maxTime = 0;
        for (int d : dist.values()) {
            maxTime = Math.max(maxTime, d);
        }
        return maxTime;
    }
}