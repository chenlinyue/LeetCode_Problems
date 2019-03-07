class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> column = new HashSet<Character>();
            HashSet<Character> block = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
            // In java, if an element is already in a set, the add function will return false
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !column.add(board[j][i])) return false;
                int rw = 3 * (i / 3) + j / 3, cl = 3 * (i % 3) + j % 3;
                if (board[rw][cl] != '.' && !block.add(board[rw][cl])) return false;
            }
        }
        return true;
    }
}
