class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if (startFuel >= target)
            return 0;
        
        // dp[i][j] == maximum fuel if you have refueled i times and your last refuel was at station j - 1
        int [][] dp = new int [n + 1][n + 1];
        
        for (int i = 1; i <= n; i++)
        {
            int prevRowMax = startFuel;
            for (int j = 0; j < n; j++)
            {
                if (j > 0)
                    prevRowMax = Math.max(dp[i - 1][j - 1], prevRowMax);
                
                if (prevRowMax >= stations[j][0])
                {
                    dp[i][j] = prevRowMax + stations[j][1];
                    if (dp[i][j] >= target)
                        return i;
                }
                else
                    break;
            }
        }
        
        return -1;
    }
}