class Solution {
    int [][] dirs = new int [][] {{-1, 0}, {0, -1}};
    int ROW = 0;
    int COL = 1;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        for (int row = m - 1; row >= 0; row--)
        {
            for (int col = n - 1; col >= 0; col--)
            {
                // Look up and left
                for (int[] dir : dirs)
                {
                    int nbrRow = row + dir[ROW];
                    int nbrCol = col + dir[COL];
                    
                    if (nbrRow >= 0 && nbrCol >= 0)
                    {
                        if (dp[nbrRow][nbrCol] == 0)
                            dp[nbrRow][nbrCol] = Math.max(dp[row][col] - dungeon[nbrRow][nbrCol], 1);
                        else
                            dp[nbrRow][nbrCol] = Math.min(Math.max(dp[row][col] - dungeon[nbrRow][nbrCol], 1), dp[nbrRow][nbrCol]);
                    }
                }
            }
        }
        
        // for (int [] a : dp)
        //     System.out.println(Arrays.toString(a));
        
        return dp[0][0];
    }
}