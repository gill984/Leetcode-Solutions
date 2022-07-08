class Solution {
    int target;
    int m;
    int n;
    int[] houses;
    int[][] cost;
    Map<String, Integer> memo;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new HashMap<>();
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        return dfs (0, 0, 0);
    }
    
    public int dfs (int i, int hoods, int prev) {
        String key = "" + i + "," + prev + "," + hoods;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        } else if (i == m) {
            if (hoods == target) {
                memo.put(key, 0);
                return 0;
            } else {
                // didn't hit target number of neighborhoods
                memo.put(key, -1);
                return -1;
            }
        }
        
        int min = Integer.MAX_VALUE;
        if (houses[i] == 0) {
            for (int j = 0; j < n; j++) {
                int tail = dfs(i + 1, hoods + (prev == j + 1 ? 0 : 1), j + 1);
                if (tail == -1) {
                    // Didn't find the target number of neighborhoods
                    continue;
                }
                min = Math.min(min, cost[i][j] + tail);
            }
        } else {
            // This house is already painted, no cost added from this house
            min = dfs(i + 1, hoods + (prev == houses[i] ? 0 : 1), houses[i]);
        }
        
        if (min == Integer.MAX_VALUE)
            min = -1;
        
        memo.put(key, min);
        return min;
    }
}