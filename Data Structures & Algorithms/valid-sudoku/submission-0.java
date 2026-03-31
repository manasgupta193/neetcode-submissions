class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize 9 HashSets for rows, 9 for columns, and 9 for 3x3 boxes.
        // We use arrays of Set<Character> to store these.
        Set<Character>[] rowSets = new HashSet[9];
        Set<Character>[] colSets = new HashSet[9];
        Set<Character>[] boxSets = new HashSet[9];

        // Instantiate each HashSet within the arrays.
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        // Iterate through each cell of the 9x9 board.
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentVal = board[r][c];

                // If the cell is empty ('.'), skip it as empty cells don't need validation.
                if (currentVal == '.') {
                    continue;
                }

                // Check for duplicates in the current row.
                // If 'currentVal' is already in the HashSet for this row, it's a duplicate.
                if (rowSets[r].contains(currentVal)) {
                    return false;
                }
                // Otherwise, add it to the set for this row.
                rowSets[r].add(currentVal);

                // Check for duplicates in the current column.
                // If 'currentVal' is already in the HashSet for this column, it's a duplicate.
                if (colSets[c].contains(currentVal)) {
                    return false;
                }
                // Otherwise, add it to the set for this column.
                colSets[c].add(currentVal);

                // Check for duplicates in the current 3x3 sub-box.
                // Calculate the index of the 3x3 box (0-8).
                // boxIndex = (row_block * 3) + col_block
                // row_block = r / 3 (integer division)
                // col_block = c / 3 (integer division)
                int boxIndex = (r / 3) * 3 + (c / 3);
                
                // If 'currentVal' is already in the HashSet for this box, it's a duplicate.
                if (boxSets[boxIndex].contains(currentVal)) {
                    return false;
                }
                // Otherwise, add it to the set for this box.
                boxSets[boxIndex].add(currentVal);
            }
        }

        // If all checks pass and no duplicates are found, the board is valid.
        return true;
    }
}