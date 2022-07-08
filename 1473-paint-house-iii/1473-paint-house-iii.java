class Solution {
    final int UNVISITED = 0;
    final int INVALID = Integer.MAX_VALUE;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int [][][] memo = new int [m][n][101];
        int res = dfs (0, 0, 0, houses, cost, target, memo, m, n);
        return res == INVALID ? -1 : res - 1;
    }
    
    public int dfs (int i, int hoods, int prev, int [] h, int [][] c, int t, int [][][] memo, int m, int n) {       
        if (i == m)
            return (hoods == t ? 1 : INVALID);
        else if (prev > 0 && memo[i][prev - 1][hoods] != UNVISITED)
            return memo[i][prev - 1][hoods];
        
        int min = INVALID;
        if (h[i] == 0) {
            for (int j = 0; j < n; j++) {
                int tail = dfs(i + 1, hoods + (prev == j + 1 ? 0 : 1), j + 1, h, c, t, memo, m, n);
                if (tail == INVALID)
                    continue;
                min = Math.min(min, c[i][j] + tail);
            }
        } else {
            // This house is already painted, no cost added from this house
            min = dfs(i + 1, hoods + (prev == h[i] ? 0 : 1), h[i], h, c, t, memo, m, n);
        }
        
        if (prev > 0)
            memo[i][prev - 1][hoods] = min;
        return min;
    }
}