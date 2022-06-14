class Solution {
    public int minDistance(String s, String t) {
        // If iterating through and characters don't match
        // have to delete either char 1, char 2, or both
        // keep track of minimum number of deletions needed
        // to reach each state. State is defined as all characters
        // gt i and gt j have matched.
        // dp[i,j] == min(dp[i + 1, j] + 1, dp[i, j + 1] + 1, dp[i + 1, j + 1] if match)
        int m = s.length();
        int n = t.length();
        
        int [][] dp = new int [m + 1][n + 1];
        
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (s.charAt(i - 1) == t.charAt(j - 1)) ?
                dp[i - 1][j - 1] :
                Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        
        return dp[m][n];
    }
}