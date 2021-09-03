class Solution {
    public int longestPalindromeSubseq(String ss) {
        char [] s = ss.toCharArray();
        int n = s.length;
        char [] r = new char[n];
        for (int i = 0; i < s.length; i++)
            r[i] = s[s.length - 1 - i];
        int [][] dp = new int [n + 1][n + 1];
        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                if (s[j - 1] == r[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[n][n];
    }
}