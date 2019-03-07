class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
            // Be careful about the 'Start' and assign the accessible result to 1 instead of 0
                if (i == 0 && j == 0 && obstacleGrid[i][j] != 1){
                    result[i][j] = 1;
                }else{
                    result[i][j] = 0;
                }
                
                if (obstacleGrid[i][j] == 0){
                    if (i > 0) result[i][j] += result[i - 1][j];
                    if (j > 0) result[i][j] += result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }  
}
