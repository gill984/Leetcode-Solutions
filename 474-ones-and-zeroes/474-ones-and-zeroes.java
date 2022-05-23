class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int [m + 1][n + 1];
        int [][] counts = new int [strs.length][2];
        for (int i = 0; i < strs.length; i++) 
            counts[i] = getCounts(strs[i]);
        
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);
        
        dp[0][0] = 0;
        int max = 0;
        for (int [] count : counts) {
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (dp[i][j] == -1)
                        continue;

                    int z = i + count[0];
                    int o = j + count[1];
                    if (z <= m && o <= n) {
                        dp[z][o] = Math.max(dp[z][o], dp[i][j] + 1);
                        max = Math.max(max, dp[z][o]);
                    }
                }
            }
        }   
        
        return max;
    }
    
    public int[] getCounts(String s) {
        int [] res = new int [2];
        for (char c : s.toCharArray()) {
            if (c == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
}