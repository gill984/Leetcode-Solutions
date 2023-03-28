class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int [] dp = new int [days[n - 1] + 1];      // Last day we need a ticket
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; i++) {
            int day = days[i];
            
            int prevCost = (i > 0 ? dp[days[i - 1]] : 0);
            int singleCost = prevCost + costs[0];
            int sevenCost = prevCost + costs[1];
            int thirtyCost = prevCost + costs[2];
            
            // System.out.println("day: " + day);
            // System.out.println("prevcost: " + prevCost);
            // System.out.println("singleCost: " + singleCost);
            // System.out.println("sevenCost: " + sevenCost);
            // System.out.println("thirtyCost: " + thirtyCost);
            
            dp[day] = Math.min(dp[day], singleCost);
            
            // Fill in dp with 7 and 30 day prices
            for (int j = 0; j < 7 && j + day < dp.length; j++) {
                dp[j + day] = Math.min(dp[j + day], sevenCost);
            }
            
            for (int j = 0; j < 30 && j + day < dp.length; j++) {
                dp[j + day] = Math.min(dp[j + day], thirtyCost);
            }
            
            // System.out.println(Arrays.toString(dp));
        }
        
        return dp[dp.length - 1];
    }
}