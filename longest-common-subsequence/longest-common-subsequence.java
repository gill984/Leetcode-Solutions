class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int m = t1.length;
        int n = t2.length;
        
        int [] dp = new int [n + 1];
        for (int i = 1; i <= m; i++)
        {
            int upLeftDiag = dp[0];
            for (int j = 1; j <= n; j++)
            {
                int temp = dp[j];
                dp[j] = Math.max((t1[i - 1] == t2[j - 1] ? 1 : 0) + upLeftDiag,
                           Math.max(dp[j],
                                    dp[j-1]));
                upLeftDiag = temp;
            }
        }
        return dp[n];
    }
}