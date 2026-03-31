class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // Update maxArea with the area of the island found at (r, c)
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Boundary and water checks
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        // "Sink" the land to mark it as visited
        grid[r][c] = 0;
        
        // Sum up current tile (1) + all neighbors
        return 1 + dfs(grid, r + 1, c) + 
                   dfs(grid, r - 1, c) + 
                   dfs(grid, r, c + 1) + 
                   dfs(grid, r, c - 1);
    }
}