class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int [] dp = new int [days[n - 1] + 1];      // Last day we need a ticket
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; i++) {
            int day = days[i];
            int prevCost = (i > 0 ? dp[days[i - 1]] : 0);
            
            // Fill in dp for single day, 7-day, and 30-day ticket options
            dp[day] = Math.min(dp[day], prevCost + costs[0]);
            for (int j = 0; j < 7 && j + day < dp.length; j++)
                dp[j + day] = Math.min(dp[j + day], prevCost + costs[1]);
            for (int j = 0; j < 30 && j + day < dp.length; j++)
                dp[j + day] = Math.min(dp[j + day], prevCost + costs[2]);
        }
        
        return dp[dp.length - 1];
    }
}