class Solution {
    public boolean isMatch(String ss, String ps) {
        char [] s = ss.toCharArray();
        char [] p = ps.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean [][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p[i - 1] == '*')
                dp[0][i] = true;
            else
                break;
        }
        
        
        for (int row = 1; row < m + 1; row++)
        {
            for (int col = 1; col < n + 1; col++)
            {                
                if (s[row - 1] == p[col - 1] || p[col - 1] == '?')
                {
                    dp[row][col] = dp[row - 1][col - 1];
                }
                else if (p[col - 1] == '*')
                {
                    dp[row][col] = (dp[row - 1][col - 1] || dp[row - 1][col] || dp[row][col - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}