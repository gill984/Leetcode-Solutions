class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int [] dp = new int [high + 1];
        dp [0] = 1;
        int MOD = 1000000007;
        
        for (int end = 1; end <= high; end++) {
            if (end >= zero)
                dp[end] = (dp[end] + dp[end - zero]) % MOD;
            
            if (end >= one)
                dp[end] = (dp[end] + dp[end - one]) % MOD;
            
            dp[end] %= MOD;
        }
        
        int res = 0;
        for (int i = low; i <= high; i++)
            res = (res + dp[i]) % MOD;
        
        return res;
    }
}