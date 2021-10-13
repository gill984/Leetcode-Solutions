class Solution
{
    public int search(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return -1;
        
        int pivotIndex = findPivot(nums, 0, nums.length);
        int left = Arrays.binarySearch(nums, 0, pivotIndex, target);
        int right = Arrays.binarySearch(nums, pivotIndex, nums.length, target);
        
        if(left >= 0)
            return left;
        else if(right >= 0)
            return right;
        else
            return -1;
    }
    
    // Divide and conquer to find pivot
    public int findPivot(int [] nums, int lo, int hi)
    {
        if(lo >= hi)
            return -1;
        
        // Check if the pivot could be somewhere in the current array
        if(nums[lo] > nums[hi - 1])
        {
            int leftPivot = findPivot(nums, lo, (hi + lo) / 2);
            int rightPivot = findPivot(nums, (hi + lo) / 2, hi);
            
            if(leftPivot == -1 && rightPivot == -1)
                return -1;
            else if(leftPivot == -1)
                return rightPivot;
            else if(rightPivot == -1)
                return leftPivot;
            else
                return nums[leftPivot] < nums[rightPivot] ? leftPivot : rightPivot;
        }
        else
        {
            return lo;
        }
    }
}