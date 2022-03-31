class Solution {
    public int splitArray(int[] nums, int m) {
        // Binary search over the possible sums
        // Can greedily see if a sum is fittable by trying to create intervals and appending only is we stay
        // under the sum
        // If we can create the partitioned array, then binary search for a smaller sum
        // else binary search for a larger sum
        
        // Init min to largest value in array, max to sum of all elements
        // min and max are binary search bounds
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i = 0; i < nums.length; i++)
        {
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }
        
        int min = hi;
        int mid = (hi - lo) / 2 + lo;
        while(lo <= hi)
        {
            mid = (hi - lo) / 2 + lo;
            boolean valid = isValidMin(nums, m, mid);
            if(valid)
            {
                min = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return min;
    }
    
    // Greedily create subarrays without exceeding target
    public boolean isValidMin(int [] nums, int m, int target)
    {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(sum + nums[i] <= target)
            {
                sum += nums[i];
            }
            else
            {
                count++;
                sum = nums[i];
            }
        }
        
        return (count <= m);
    }
}