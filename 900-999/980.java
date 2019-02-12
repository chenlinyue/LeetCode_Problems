class Solution {
    int result = 0, empty = 1, sx, sy;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 0){
                    empty++;
                }else if (grid[i][j] == 1){
                    sx = i; 
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return result;
    }
    
    public void dfs(int[][] grid, int x0, int y0){
        if (!check(grid, x0, y0)) return;
        if (grid[x0][y0] == 2 && empty == 0){
            result++;
            return;
        }
        int temp = grid[x0][y0];
        grid[x0][y0] = -1;
        empty--;
        
        dfs(grid, x0 + 1, y0);
        dfs(grid, x0 - 1, y0);
        dfs(grid, x0, y0 + 1);
        dfs(grid, x0, y0 - 1);
        
        grid[x0][y0] = temp;
        empty++;
    }
    
    public boolean check(int[][] grid, int x, int y){
        int n = grid.length, m = grid[0].length;
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] >= 0;
    }
}
