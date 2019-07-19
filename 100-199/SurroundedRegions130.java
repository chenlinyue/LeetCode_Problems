public void solve(char[][] board) {
    int n = board.length;
    if (n <= 0) return;
    int m = board[0].length;

    for (int j = 0; j < m; j++){
        checkNeighbour(board, 0, j, n, m);
    }
    for (int i = 0; i < n; i++){
        if (m - 1 >= 0)
            checkNeighbour(board, i, m - 1, n, m);
    }
    for (int j = m - 1; j >= 0; j--){
        if (n - 1 >= 0)
            checkNeighbour(board, n - 1, j, n, m);
    }
    for (int i = n - 1; i >= 0; i--){
        checkNeighbour(board, i, 0, n, m);
    }

    for (int i = 0; i < n ;i++){
        for (int j = 0; j < m; j++){
            if (board[i][j] == 'O') board[i][j] = 'X';
            if (board[i][j] == 1) board[i][j] = 'O';
        }
    }
}

public void checkNeighbour(char[][] board, int i, int j, int rows, int cols){

    if (board[i][j] == 'O'){

        board[i][j] = 1;

        if (j - 1 > 0)
            checkNeighbour(board, i, j - 1, rows, cols);
        if (j + 1 < cols - 1)
            checkNeighbour(board, i, j + 1, rows, cols);
        if (i - 1 > 0)
            checkNeighbour(board, i - 1, j, rows, cols);
        if (i + 1 < rows - 1)
            checkNeighbour(board, i + 1, j, rows, cols);
    }

}
