class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // dp[i] = max amount which can be stolen by house i
        int [] dp = new int [n];
        dp[0] = nums[0];
        int max = nums[0];
        if (n > 1)
        {
            dp[1] = Math.max(nums[0], nums[1]);
            max = Math.max(max, dp[1]);
        }
        
        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        
        return max;
    }
}