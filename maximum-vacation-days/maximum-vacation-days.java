import java.util.Arrays;

class Solution
{
    public int maxVacationDays(int[][] flights, int[][] days)
    {
        if(flights == null || days == null)
            return 0;
        
        // number of cities
        int c = days.length;
        
        // number of weeks
        int w = days[0].length;
        
        // dp[i][j] == max vacation days possible including week j if in city i this week
        int [][] dp = new int[days.length][days[0].length];
        
        // Base case, week 1 can start in any of the cities if we can fly there from the first city where we have to start
        for(int i = 0; i < c; i++)
        {
            if(i == 0 || flights[0][i] == 1)
                dp[i][0] = days[i][0];
            else
                dp[i][0] = Integer.MIN_VALUE;
        }
        
        for(int i = 0; i < c; i++)
        {
            for(int j = 1; j < w; j++)
            {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        // Subproblem, next week is the max possible from the previous week
        
        // For each week
        for(int j = 1; j < w; j++)
        {
            // For each city
            for(int i = 0; i < c; i++)
            {
                // For each neighboring city
                for(int n = 0; n < c; n++)
                {
                    // If we can fly from n to this city, also if we stay
                    if(dp[n][j-1] == Integer.MIN_VALUE)
                    {
                        continue;
                    }
                    else if(n == i || flights[n][i] == 1)
                    {
                        // Maximum between the previous cities max plus this cities vacation, and the current max
                        dp[i][j] = Math.max(dp[n][j-1] + days[i][j], dp[i][j]);
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < c; i++)
        {
            max = Math.max(max, dp[i][w-1]);
        }
        
        System.out.println(Arrays.deepToString(dp));
        
        return max;
    }
}