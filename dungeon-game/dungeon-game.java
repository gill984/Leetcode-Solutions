class Solution {
    final int ROW = 0;
    final int COL = 1;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);
        for (int row = m - 1; row >= 0; row--)
        {
            for (int col = n - 1; col >= 0; col--)
            {
                int nbrRow = row + -1;
                int nbrCol = col + 0;

                if (nbrRow >= 0 && nbrCol >= 0)
                {
                    int cell = dungeon[nbrRow][nbrCol];
                    int path = Math.max(dp[row][col] - cell, 1);
                    int saved = dp[nbrRow][nbrCol];
                    if (saved == 0 || path < saved)
                        dp[nbrRow][nbrCol] = path;
                }
                
                // Look at up and left directions
                nbrRow = row;
                nbrCol = col - 1;

                if (nbrRow >= 0 && nbrCol >= 0)
                {
                    int cell = dungeon[nbrRow][nbrCol];
                    int path = Math.max(dp[row][col] - cell, 1);
                    int saved = dp[nbrRow][nbrCol];
                    if (saved == 0 || path < saved)
                        dp[nbrRow][nbrCol] = path;
                }
            }
        }
        
        return dp[0][0];
    }
}