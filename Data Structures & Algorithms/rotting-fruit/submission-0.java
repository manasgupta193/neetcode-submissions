class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // 1. Initial scan: Find all rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges, it takes 0 minutes
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // 2. Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisRound = false;
            
            // Process all oranges that turned rotten in the PREVIOUS minute
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Infect
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        infectedThisRound = true;
                    }
                }
            }
            if (infectedThisRound) minutes++;
        }
        
        // 3. Final check: Are there any fresh oranges left?
        return freshCount == 0 ? minutes : -1;
    }
}