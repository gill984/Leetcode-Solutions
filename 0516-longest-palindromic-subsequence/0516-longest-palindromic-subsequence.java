class Solution {
    public int longestPalindromeSubseq(String ss) {
        char [] s = ss.toCharArray();
        int n = s.length;
        char [] r = new char[n];
        for (int i = 0; i < s.length; i++)
            r[i] = s[s.length - 1 - i];
        int [] dp = new int [n + 1];
        for (int i = 1; i < n + 1; i++)
        {
            int upLeft = dp[0];
            for (int j = 1; j < n + 1; j++)
            {
                int temp = dp[j];
                if (s[j - 1] == r[i - 1])
                    dp[j] = Math.max(upLeft + 1, Math.max(dp[j], dp[j - 1]));
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                upLeft = temp;
            }
        }
        
        return dp[n];
    }
}