class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxI[] = new int[grid.length];
        int maxJ[] = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] > maxJ[i]){
                    maxJ[i] = grid[i][j];
                }
                if (grid[i][j] > maxI[j]){
                    maxI[j] = grid[i][j];
                }
            }
        }
        // Get the height of biggest possible heights in 2 lines
        
        int[][] gridMax = new int[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                result = result + (maxI[j] > maxJ[i] ? maxJ[i] : maxI[j]) - grid[i][j];
            }
        }
        return result;        
    }
}
