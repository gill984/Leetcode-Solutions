class Solution {
    public int[] countBits(int n) {
        int [] dp = new int [n + 1];
        dp[0] = 0;
        
        if (n == 0)
            return dp;
        
        dp[1] = 1;
        int pow = 1;
        
        for (int i = 2; i < dp.length; i++)
        {
            if (pow * 2 == i)
            {
                dp[i] = 1;
                pow = i;
            }
            else
            {
                dp[i] = 1 + dp[i - pow];
            }
        }
        
        return dp;
    }
}