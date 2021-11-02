class Solution {
    int m;
    int n;
    int freeSpaces;
    int [][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int startRow = 0;
        int startCol = 0;
        freeSpaces = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    startRow = i;
                    startCol = j;
                }
                else if (grid[i][j] == 0)
                {
                    freeSpaces += 1;
                }
            }
        }
        
        int res = dfs(grid, startRow, startCol, 0);
        return res;
    }
    
    public int dfs (int[][] grid, int row, int col, int freeVisited)
    {
        // System.out.println("Row: " + row + ", Col: " + col);
        int numPaths = 0;
        
        for (int [] dir : dirs)
        {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n)
            {
                if (grid[nextRow][nextCol] == 0)
                {
                    grid[nextRow][nextCol] = 1;
                    numPaths += dfs(grid, nextRow, nextCol, freeVisited + 1);
                    grid[nextRow][nextCol] = 0;
                }
                else if (grid[nextRow][nextCol] == 2 && freeVisited == freeSpaces)
                {
                    numPaths += 1;
                }
            }
        }
        
        return numPaths;
    }
}