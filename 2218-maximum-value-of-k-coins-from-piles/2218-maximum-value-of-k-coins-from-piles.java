class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // Compute presums, basically summed values if taking repeatedly from the same pile
        // Use presum array as if it were input to the knapsack problem, consider the number
        // of coins taken as the weight and presum value as the value.
        int n = piles.size();
        int [][] presums = new int [n][k + 1];
        
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= piles.get(i).size() && j <= k; j++)
                presums[i][j] = presums[i][j - 1] + piles.get(i).get(j - 1);
        
        int [] dp = new int [k + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            // Need this temp array to stay the same value in a given row
            // we can't decide to take a different number of coins from a single
            // pile within 1 solution
            int [] temp = dp.clone();
            for (int j = 1; j <= piles.get(i).size() && j <= k; j++)
                knapsackStep(presums, dp, temp, i, j);
        }
        
        return dp[k];
    }
    
    public void knapsackStep(int [][] presums, int [] dp, int [] temp, int row, int weight) {
        for (int i = dp.length - 1; i >= 0; i--)
            if (temp[i] >= 0 && i + weight < dp.length)
                dp[i + weight] = Math.max(dp[i + weight], temp[i] + presums[row][weight]);
    }
}