class Solution
{
    public int singleNonDuplicate(int[] nums)
    {
        // First instinct is to use binary search
        // Overall length of array will be odd, 2 * k + 1
        // Can binary search
        // 0  1  2  3  4  5  6
        // 1, 1, 2, 2, 3, 4, 4
        // if the index chosen is even and matches the index after it, value is to the right, else left
        // if the index chosen is odd and matches the index before it, value is to the right, else left
        // Value will always be at an even index
        int hi = nums.length - 1;
        int lo = 0;
        int mid = 0;
        
        while (hi >= lo)
        {
            mid = (hi - lo) / 2 + lo;
            
            if (mid % 2 == 0)
            {
                if (mid != nums.length - 1 && nums[mid] == nums[mid + 1])
                    lo = mid + 2;
                else if (mid != 0 && nums[mid] == nums[mid - 1])
                    hi = mid - 2;
                else
                    return nums[mid];
            }
            else
            {
                if (nums[mid] == nums[mid - 1])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        
        return mid;
    }
}