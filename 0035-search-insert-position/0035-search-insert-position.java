class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int val = nums[mid];
            if (target == val) {
                return mid;
            } else if (val > target) {
                hi = mid - 1;
            } else if (val < target) {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}