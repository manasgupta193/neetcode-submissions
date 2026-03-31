class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    dp[j] = 0; // Intersection is blocked
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // Current (top) + Left
                }
            }
        }
        return dp[n - 1];
    }
}