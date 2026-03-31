class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        
        // {row, col, max_height_so_far}
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            
            if (r == n - 1 && c == n - 1) return t;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The time to reach (nr, nc) is the max of current time and its own height
                    pq.offer(new int[]{nr, nc, Math.max(t, grid[nr][nc])});
                }
            }
        }
        return -1;
    }
}