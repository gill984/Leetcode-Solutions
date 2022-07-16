class Solution {
    final int MOD = 1000000007;
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        int [][][] dp = new int [maxMove + 2][m][n];
        dp[0][startRow][startColumn] = 1;
        
        for (int move = 0; move < maxMove; move++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[move][i][j] == 0)
                        continue;
                    
                    for (int [] dir : dirs) {
                        int nextRow = i + dir[0];
                        int nextCol = j + dir[1];
                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n)
                            res = (res + dp[move][i][j]) % MOD;
                        else
                            dp[move + 1][nextRow][nextCol] = (dp[move + 1][nextRow][nextCol] + dp[move][i][j]) % MOD;
                    }
                }
                
            }
        }
        
        return res;
    }
}