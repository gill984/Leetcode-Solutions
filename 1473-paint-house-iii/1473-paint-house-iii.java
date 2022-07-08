class Solution {
    final int UNVISITED = -1;
    final int INVALID = Integer.MAX_VALUE;
    int target;
    int m;
    int n;
    int[] houses;
    int[][] cost;
    int [][][] memo;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new int [m][n][101];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], UNVISITED);
        
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        int res = dfs (0, 0, 0);
        return res == INVALID ? -1 : res;
    }
    
    public int dfs (int i, int hoods, int prev) {       
        if (i == m)
            return (hoods == target ? 0 : INVALID);
        else if (prev > 0 && memo[i][prev - 1][hoods] != UNVISITED)
            return memo[i][prev - 1][hoods];
        
        int min = INVALID;
        if (houses[i] == 0) {
            for (int j = 0; j < n; j++) {
                int tail = dfs(i + 1, hoods + (prev == j + 1 ? 0 : 1), j + 1);
                if (tail == INVALID)
                    continue;
                min = Math.min(min, cost[i][j] + tail);
            }
        } else {
            // This house is already painted, no cost added from this house
            min = dfs(i + 1, hoods + (prev == houses[i] ? 0 : 1), houses[i]);
        }
        
        if (prev > 0)
            memo[i][prev - 1][hoods] = min;
        return min;
    }
}