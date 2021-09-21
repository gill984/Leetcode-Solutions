class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 1)
            {
                count++;
                res = Math.max(res, count);
            }
            else
            {
                count = 0;
            }
        }
        
        return res;
    }
}