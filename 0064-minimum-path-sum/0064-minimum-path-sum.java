class Solution {
    int INF = 1000000;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                
                grid[i][j] += Math.min(i > 0 ? grid[i - 1][j] : INF, j > 0 ? grid[i][j - 1] : INF);
            }
        }
        
        return grid[m - 1][n - 1];
    }
}