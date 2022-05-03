class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int [] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int count = nums.length;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == sorted[i])
                count--;
            else
                break;
        }
        
        if(count == 0)
            return 0;
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] == sorted[i])
                count--;
            else
                break;
        }
        
        return count;
    }
}