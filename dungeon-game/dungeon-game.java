class Solution {
    // Key is starting from bottom right and moving towards beginning cell    
    // LEFT and UP
    int[][] dirs = new int[][] {{0, -1}, {-1, 0}};
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
                // Look at up and left directions
                for (int[] dir : dirs)
                {
                    int nbrRow = row + dir[ROW];
                    int nbrCol = col + dir[COL];
                    
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
        }
        
        return dp[0][0];
    }
}