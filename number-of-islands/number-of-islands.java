class Solution {
    int [][] dirs = new int [][] {{-1 , 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int row, int col)
    {
        for (int [] dir : dirs)
        {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if (nextRow >= 0 && nextRow < grid.length &&
                nextCol >= 0 && nextCol < grid[0].length &&
                grid[nextRow][nextCol] == '1')
            {
                grid[nextRow][nextCol] = '0';
                dfs(grid, nextRow, nextCol);
            }
        }
    }
}