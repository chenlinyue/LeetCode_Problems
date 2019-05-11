class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        if (row <= 0){
            return A;
        }
        int col = A[0].length;
        if (col <= 0){
            return A;
        }
        
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                result[i][j] = A[i][col - j - 1] == 0 ? 1 : 0;
            }
        }
        return result;
    }
}
