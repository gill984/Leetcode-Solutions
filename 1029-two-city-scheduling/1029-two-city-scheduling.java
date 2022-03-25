class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort by difference between the two cities
        // 2 buckets, A preferred or B preferred
        // Match off the largest A preferred and B
        // preferred cities
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int res = 0;
        int n = costs.length;
        
        for (int i = 0; i < n / 2; i++)
        {
            res += costs[i][0];
            res += costs[n - 1 - i][1];
        }
        
        return res;
    }
}