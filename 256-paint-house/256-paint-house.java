class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int k = 3;
        int [][] dp = new int [n][k];
        int [][] mins = new int [n][2];
        
        for (int i = 0; i < n; i++)
        {
            mins[i][0] = 0;
            mins[i][1] = 1;
        }
        
        // Case 0 is that we always just start with row designated color on the first house
        for (int h = 0; h < n; h++)
        {
            for (int col = 0; col < k; col++)
            {
                int cost = costs[h][col];
                
                // Update dp array
                if (h == 0)
                {
                    dp[0][col] = cost;
                }
                else if (col != mins[h - 1][0])
                {
                    dp[h][col] = dp[h - 1][mins[h - 1][0]] + cost;
                }
                else
                {
                    dp[h][col] = dp[h - 1][mins[h - 1][1]] + cost;
                }
                
                // Minimums
                if (dp[h][col] < dp[h][mins[h][0]])
                {
                    mins[h][1] = mins[h][0];
                    mins[h][0] = col;
                }
                else if (dp[h][col] < dp[h][mins[h][1]])
                {
                    mins[h][1] = col;
                }
            }
        }
        
//         System.out.println("dp:");
//         for (int i = 0; i < n; i++)
//             System.out.println(Arrays.toString(dp[i]));
        
//         System.out.println("Mins:");
//         for (int i = 0; i < n; i++)
//             System.out.println(Arrays.toString(mins[i]));
        return dp[n - 1][mins[n - 1][0]];
    }
}