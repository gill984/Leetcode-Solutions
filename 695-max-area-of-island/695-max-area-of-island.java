class Solution {
    int [][] dirs = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, grid));
            }
        }
        
        return max;
    }
    
    public int dfs (int row, int col, int [][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        
        int val = grid[row][col];
        if (val == 0 || val == 2) {
            return 0;
        }
        grid[row][col] = 2;
        
        for (int [] dir : dirs) {
            val += dfs (row + dir[0], col + dir[1], grid);
        }
        
        return val;
    }
}