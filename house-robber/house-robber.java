class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1)
            return nums[0];
        
        // dp[i] = max amount which can be stolen by house i
        int twoPrev = nums[0];
        int onePrev = Math.max(nums[0], nums[1]);
        int max = Math.max(onePrev, twoPrev);
        
        for (int i = 2; i < n; i++)
        {
            max = Math.max(nums[i] + twoPrev, onePrev);
            twoPrev = onePrev;
            onePrev = max;
        }
        
        return max;
    }
}