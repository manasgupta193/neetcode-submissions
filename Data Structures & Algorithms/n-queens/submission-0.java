class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        // Trackers for O(1) safety checks
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r + c
        boolean[] diag2 = new boolean[2 * n]; // r - c

        backtrack(result, board, 0, n, cols, diag1, diag2);
        return result;
    }

    private void backtrack(List<List<String>> res, char[][] board, int r, int n, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (r == n) {
            res.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r + c;
            int d2 = r - c + n; // +n to avoid negative indices

            if (!cols[c] && !diag1[d1] && !diag2[d2]) {
                // Place Queen
                board[r][c] = 'Q';
                cols[c] = diag1[d1] = diag2[d2] = true;

                backtrack(res, board, r + 1, n, cols, diag1, diag2);

                // Backtrack (Clean up)
                board[r][c] = '.';
                cols[c] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}