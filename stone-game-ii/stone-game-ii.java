class Solution {
    int n;
    int[][] memo;
    int[] presum;
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for (int i = n - 2; i >= 0; i--)
            piles[i] = piles[i] + piles[i + 1];
        memo = new int[n][n];
        presum = piles;
        return dfs(0, 1);
    }
    
    // dfs returns the maximum amount of stones more a player
    // can get if they are at pile i with value m
    public int dfs(int i, int m)
    {
        if (2 * m + i >= n)
            return presum[i];
        else if (memo[i][m] > 0)
            return memo[i][m];
        
        // Get best answer for all choices of x [1..2m]
        // presum[i] is the total amount of stones left
        // dfs call finds the maximum amount of stones our opponent will be able
        // to get if we take x piles
        int res = 0;
        for (int x = 1; x <= 2 * m; x++)      
            res = Math.max(res, presum[i] - dfs(i + x, Math.max(x, m)));
        
        memo[i][m] = res;
        return res;
    }
}