class Solution {
    public int findMin(int[] nums) {
        // Find pivot spot by binary searching for it
        // Return the element just after the pivot
        return nums[getPivot(nums)];
    }
    
    public int getPivot(int [] nums)
    {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (hi > lo)
        {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[lo])
            {
                if (nums[mid - 1] > nums[mid])
                    return mid;
                hi = mid - 1;
            }
            else if (nums[mid] > nums[hi])
            {
                if (nums[mid + 1] < nums[mid])
                    return mid + 1;
                lo = mid + 1;
            }
            else
            {
                // This array is sorted
                return 0;
            }
        }
        
        return (lo + hi) / 2;
    }
}