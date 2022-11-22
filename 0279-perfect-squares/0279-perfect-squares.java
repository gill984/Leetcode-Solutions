class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            squares.add(i * i);
        int [] dp = new int [n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = squares.size() - 1; i >= 0; i--) {
            int sq = squares.get(i);
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] != -1 && j + sq < dp.length) {
                    dp[j + sq] = (dp[j + sq] != -1) ? Math.min(dp[j] + 1, dp[j + sq]) : dp[j] + 1;
                }
            }
        }
        
        return dp[n];
    }
}