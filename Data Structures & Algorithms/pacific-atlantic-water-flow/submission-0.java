class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;

        // Two boolean matrices to track reachability from each ocean
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 1. Start DFS from Top/Bottom edges (Horizontal)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacific); // Top edge -> Pacific
            dfs(heights, rows - 1, c, Integer.MIN_VALUE, atlantic); // Bottom edge -> Atlantic
        }

        // 2. Start DFS from Left/Right edges (Vertical)
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, Integer.MIN_VALUE, pacific); // Left edge -> Pacific
            dfs(heights, r, cols - 1, Integer.MIN_VALUE, atlantic); // Right edge -> Atlantic
        }

        // 3. Find intersection where both are true
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] ocean) {
        // Boundary checks + Height check (must be uphill or equal) + Visited check
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || 
            heights[r][c] < prevHeight || ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;
        
        // Explore 4 directions
        dfs(heights, r + 1, c, heights[r][c], ocean);
        dfs(heights, r - 1, c, heights[r][c], ocean);
        dfs(heights, r, c + 1, heights[r][c], ocean);
        dfs(heights, r, c - 1, heights[r][c], ocean);
    }
}