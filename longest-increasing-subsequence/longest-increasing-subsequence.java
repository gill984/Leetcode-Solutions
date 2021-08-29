class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int length = 0;
        
        if(nums == null || nums.length == 0)
            return 0;
        
        for (int x : nums)
        {
            int i = Arrays.binarySearch(dp, 0, length, x);
            if(i < 0)
                i = -(i + 1);
            
            dp[i] = x;
            
            if (i == length)
                length++;
        }
        
        return length;
    }
}