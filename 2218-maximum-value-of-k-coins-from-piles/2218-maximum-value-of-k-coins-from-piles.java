class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // dp[i][j] = max if we take only from piles 0-i and we take j top coins from pile i
        int n = piles.size();
        int [][] presums = new int [n][k + 1];
        
        // Base case for first pile
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= piles.get(i).size() && j <= k; j++) {
                presums[i][j] = presums[i][j - 1] + piles.get(i).get(j - 1);
            }
        }
        
        int [] dp = new int [k + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int [] temp = dp.clone();
            for (int j = 1; j <= piles.get(i).size() && j <= k; j++) {
                knapsackStep(presums, dp, temp, i, j);
            }
        }
        
        return dp[k];
    }
    
    public void knapsackStep(int [][] presums, int [] dp, int [] temp, int row, int weight) {
        for (int i = dp.length - 1; i >= 0; i--) {
            if (temp[i] >= 0 && i + weight < dp.length) {
                dp[i + weight] = Math.max(dp[i + weight], temp[i] + presums[row][weight]);
            }
        }
    }
}