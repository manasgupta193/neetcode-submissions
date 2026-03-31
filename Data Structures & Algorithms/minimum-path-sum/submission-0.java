class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Use a 1D array to store the min path sums for the current row
        int[] dp = new int[n];
        
        // Initialize the first cell
        dp[0] = grid[0][0];
        
        // Initialize the rest of the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Fill the rest of the grid row by row
        for (int i = 1; i < m; i++) {
            // First element of each row can only come from above
            dp[0] += grid[i][0];
            
            for (int j = 1; j < n; j++) {
                // Min of (coming from above [dp[j]]) or (coming from left [dp[j-1]])
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        return dp[n - 1];
    }
}