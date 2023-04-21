class Solution {
    int MOD = 1000000007;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int [][] dp = new int [minProfit + 1][n + 1];
        dp[0][0] = 1;
        
        for (int i = 0; i < group.length; i++) {
            for (int row = minProfit; row >= 0; row--) {
                for (int col = n; col >= 0; col--) {
                    if (dp[row][col] == 0)
                        continue;
                    
                    int nextRow = Math.min(row + profit[i], minProfit);
                    int nextCol = group[i] + col;

                    if (nextCol > n)
                        continue;

                    dp[nextRow][nextCol] = (dp[row][col] + dp[nextRow][nextCol]) % MOD;
                }
            }
        }
        
        int sum = 0;
        for (int i : dp[minProfit]) {
            sum = (sum + i) % MOD;
        }
        return sum;
    }
}