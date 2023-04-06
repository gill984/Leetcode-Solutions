class Solution {
    int m;
    int n;
    int [][] dirs = new int [][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean isClosed;
    
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    isClosed = true;
                    dfsClosed(i, j, grid);
                    res += (isClosed ? 1 : 0);
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(grid));
        
        return res;
    }
    
    public void dfsClosed(int row, int col, int [][] grid) {
        grid[row][col] = 2;
        
        // Note this also does a bounds check for us, so we don't need it later
        // an island isn't closed iff it has a piece of land on the edge
        if (row == m - 1 || col == n - 1 || row == 0 || col == 0) {
            isClosed = false;
        }
        
        for (int [] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n)
                continue;
            
            if (grid[nextRow][nextCol] == 1 || grid[nextRow][nextCol] == 2)
                continue;
            
            dfsClosed(nextRow, nextCol, grid);
        }
    }
}