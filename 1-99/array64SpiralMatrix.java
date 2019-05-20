public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0)
            return res;
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd){
            
            // traverse right
            for (int i = colStart; i <= colEnd; i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            // traverse down
            for (int j = rowStart; j <= rowEnd; j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            // traverse left
            if (rowStart <= rowEnd){
                for (int i = colEnd; i >= colStart; i--){
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            // traverse up
            if (colStart <= colEnd){
                for (int j = rowEnd; j >= rowStart; j--){
                    res.add(matrix[j][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }
