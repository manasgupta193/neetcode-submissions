class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        backtrack(0, board);
        return count;
    }

    private void backtrack(int row, char[][] board) {
        if (row == board.length) {
            count++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    if (j == col || Math.abs(row - i) == Math.abs(col - j)) return false;
                }
            }
        }
        return true;
    }
}