class Solution {
    int m;
    int n;
    
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < n; i++) {
            dfsEdge(grid, 0, i);
            dfsEdge(grid, m - 1, i);
        }
        
        for (int i = 0; i < m; i++) {
            dfsEdge(grid, i, 0);
            dfsEdge(grid, i, n - 1);
        }
        
        int res = 0;
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (grid[i][j] == 1)
                    res++;
        
        return res;
    }
    
    int [][] dirs = new int [][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public void dfsEdge(int[][] grid, int row, int col) {
        if (grid[row][col] != 1)
            return;
        
        grid[row][col] = 2;
        
        for (int [] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n ||
                grid[nextRow][nextCol] != 1)
                continue;
            
            dfsEdge(grid, nextRow, nextCol);
        }
    }
}