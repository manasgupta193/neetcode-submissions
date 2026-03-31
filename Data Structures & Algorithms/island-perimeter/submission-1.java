class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // If we hit water or boundary, we found 1 unit of perimeter
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 1;
        }
        // If already visited, don't count it again
        if (grid[r][c] == -1) return 0;
        
        grid[r][c] = -1; // Mark as visited
        
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + 
               dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}