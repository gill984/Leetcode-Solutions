class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int leftIdx = binarySearchLeft(nums, target);
        
        if (leftIdx < 0 || leftIdx >= n || nums[leftIdx] != target)
            return false;
        
        int rightIdx = leftIdx + n / 2;
        if (rightIdx < n && nums[rightIdx] == target)
            return true;
        return false;
    }
    
    public int binarySearchLeft(int [] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int val = nums[mid];
            if (val >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}