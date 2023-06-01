class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double [][] dp = new double [n + 1][n + 1];
        
        dp[0][0] = 1.0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1.0 - prob[i - 1]);
            dp[i][i] = dp[i - 1][i - 1] * prob[i - 1];
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target && j < i; j++) {
                // From -1 heads
                dp[i][j] += dp[i - 1][j - 1] * prob[i - 1];
                dp[i][j] += dp[i - 1][j] * (1.0 - prob[i - 1]);
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[n][target];
    }
}