class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (n == 0 || k == 0)
            return 1.0;
        
        int length = Math.max(n + 1, maxPts + 1);
        double [] dp = new double [length];
        dp[0] = 1.00;
        
//         double [] dp2 = new double [n + 1];
//         dp2[0] = 1.00;
//         for (int i = 1; i <= n; i++) {
//             for (int j = Math.max(i - maxPts, 0); j < i; j++) {
//                 if (j < k)
//                     dp2[i] += (dp2[j] / maxPts);
//             }
//         }
        
//         System.out.println(Arrays.toString(dp2));
        
        for (int i = 1; i < length; i++) {
            if (i > 1)
                dp[i] += dp[i - 1];
            
            if (i <= k)
                dp[i] += dp[i - 1] / maxPts;
            
            if (i - maxPts - 1 >= 0 && dp[i] > 0.0)
                dp[i] -= dp[i - maxPts - 1] / maxPts;
        }
        
        // System.out.println(Arrays.toString(dp));
        
        double res = 0.0;
        dp[0] = 0.0;
        for (int i = k; i <= n; i++) {
            res += dp[i];
        }
        
        return res;
    }
}