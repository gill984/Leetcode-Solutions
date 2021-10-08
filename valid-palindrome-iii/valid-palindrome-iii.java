class Solution {
    public boolean isValidPalindrome(String ss, int k) {
        char [] s = ss.toCharArray();
        int n = s.length;
        int [][] dp = new int [n + 1][n + 1];
        boolean res = false;
        for (int i = 0; i <= n; i++)
        {
            dp[0][i] = i;
            dp[i][0] = i;
        }
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s[i - 1] == s[n - j])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
                
                if (i + j >= n && dp[i][j] <= k)
                    res = true;
            }
        }
        
        // for (int[] d : dp)
        //     System.out.println(Arrays.toString(d));
        
        return res;
    }
}