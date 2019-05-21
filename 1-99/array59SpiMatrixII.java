public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int k = 1;
        
        while (k <= n * n){
            
            // traverse right
            for (int i = colStart; i <= colEnd; i++){
                res[rowStart][i] = k++;
            }
            rowStart++;
            
            // traverse down
            for (int i = rowStart; i <= rowEnd; i++){
                res[i][colEnd] = k++;
            }
            colEnd--;
            
            // traverse left
            if (k <= n * n){
                for (int i = colEnd; i >= colStart; i--){
                    res[rowEnd][i] = k++;
                }
                rowEnd--;
            }
            
            // traverse up
            if (k <= n * n){
                for (int i = rowEnd; i >= rowStart; i--){
                    res[i][colStart] = k++;
                }
                colStart++;
            }
        }
        return res;
    }
