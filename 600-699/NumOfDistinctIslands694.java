    /* 
    When it comes to questions about islands, the comman solution is using DFS to get info about the island
    In this question, the key is finding a way to represent the shape of an island.
    */
    
    
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int numDistinctIslands(int[][] grid) {
        int rowNum = grid.length;
        if (rowNum == 0) return 0;
        int colNum = grid[0].length;
        // the feature of Set can help us to exclude same result
        HashSet<String> shapes = new HashSet<>();
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if (grid[i][j] == 1){
                    StringBuffer empty = new StringBuffer();
                    StringBuffer island = getShapeString(0, 0, i, j, grid, empty);
                    shapes.add(island.toString());
                }
            }
        }
        
        return shapes.size();
        
    }
    
    // the shape string should only contains info about directions instead of specific position
    public StringBuffer getShapeString(int startx, int starty, int i, int j, int[][] grid, StringBuffer previous){
        grid[i][j] = 0;
        previous.append(startx + "" + starty);
        
        for (int k = 0; k < dirs.length; k++){
            int movedI = i + dirs[k][0], movedJ = j + dirs[k][1];
            
            if (movedI >= 0 && movedI < grid.length && movedJ >= 0 && movedJ < grid[0].length && grid[movedI][movedJ] == 1)
                // the shape of island is represent as in the postions to the first found island part
                getShapeString(startx + dirs[k][0], starty + dirs[k][1], movedI, movedJ, grid, previous);
        }
        return previous;
    }
