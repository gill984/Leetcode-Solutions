class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int length = 0;
        
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i + 1);
            }
            
            dp[i] = num;
            if (i == length) {
                length++;
            }
        }
        
        return length;
    }
}