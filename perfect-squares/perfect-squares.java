class Solution {
    public int numSquares(int n) {
        int [] dp = new int [n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            squares.add(i * i);
        
        for (int s = squares.size() - 1; s >= 0; s--)
        {
            int square = squares.get(s);
            for (int i = 0; i < dp.length; i++)
            {
                if (dp[i] != -1 && i + square <= n)
                {
                    if (dp[i + square] == -1)
                        dp[i + square] = dp[i] + 1;
                    else
                        dp[i + square] = Math.min(dp[i + square], dp[i] + 1);
                }
            }
        }
        
        return dp[n];
    }
}