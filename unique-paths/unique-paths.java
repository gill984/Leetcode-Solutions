class Solution {
    public int uniquePaths(int m, int n) {
        // Catalan number but I don't remember how to calculate it
        // use a dp array
        // dp[i][j] = number of ways to reach grid[i][j] == dp[i - 1][j] + dp[i][j - 1]
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = dp[i][j] + ((i > 0) ? dp[i - 1][j] : 0) + ((j > 0) ? dp[i][j - 1] : 0);
        
        return dp[m - 1][n - 1];
    }
}