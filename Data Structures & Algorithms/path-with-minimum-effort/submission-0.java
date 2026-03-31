class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        int[][] dist = new int[r][c];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // {row, col, effort}

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], effort = curr[2];

            if (effort > dist[x][y]) continue;
            if (x == r - 1 && y == c - 1) return effort;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    // The effort to reach neighbor is max of current path effort 
                    // and the jump to the neighbor
                    int nextEffort = Math.max(effort, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (nextEffort < dist[nx][ny]) {
                        dist[nx][ny] = nextEffort;
                        pq.offer(new int[]{nx, ny, nextEffort});
                    }
                }
            }
        }
        return 0;
    }
}