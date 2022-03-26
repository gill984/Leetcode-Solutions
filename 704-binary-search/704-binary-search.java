class Solution {
    public int search(int[] nums, int target)
    {
        if(nums == null)
            return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi)
        {
            int mid = (hi + lo) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        
        return -1;
    }
}