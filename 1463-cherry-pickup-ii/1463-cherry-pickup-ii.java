class Solution {    
    public int cherryPickup(int[][] grid) {
        // dp[row][col1][col2]
        // Max cherries with robots at row, robot1 at col1, robot2 at col2
        int m = grid.length;
        int n = grid[0].length;
        int [][][] dp = new int [m][n][n];        
        
        // To reach dp[i][j][k], can come from dp[i - 1][j - 1, j, j + 1][k - 1, k, k + 1]
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    if (i != m - 1)
                        for (int nextJ = j - 1; nextJ <= j + 1; nextJ++)
                            for (int nextK = k - 1; nextK <= k + 1; nextK++)
                                if (nextJ < n && nextJ >= 0 && nextK < n && nextK >= 0)
                                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i + 1][nextJ][nextK]);
                    
                    dp[i][j][k] += grid[i][j] + (j != k ? grid[i][k] : 0);
                }
        
        return dp[0][0][n - 1];
    }
}