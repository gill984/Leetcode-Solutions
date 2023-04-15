class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // Compute presums, basically summed values if taking repeatedly from the same pile
        // Use presum array as if it were input to the knapsack problem, consider the number
        // of coins taken as the weight and presum value as the value.
        int n = piles.size();
        int [] dp = new int [k + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int presum = 0;
            int [] temp = dp.clone();
            for (int j = 1; j <= piles.get(i).size() && j <= k; j++) {
                presum += piles.get(i).get(j - 1);
                knapsackStep(presum, dp, temp, j);
            }
        }
        
        return dp[k];
    }
    
    public void knapsackStep(int presum, int [] dp, int [] temp, int weight) {
        for (int i = dp.length - 1; i >= 0; i--)
            if (temp[i] >= 0 && i + weight < dp.length)
                dp[i + weight] = Math.max(dp[i + weight], temp[i] + presum);
    }
}