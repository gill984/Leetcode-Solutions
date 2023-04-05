class Solution {
    public int minimizeArrayValue(int[] nums) {
        int hi = 1000000000;
        int lo = 0;
        
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (canUseMinValue(nums, mid))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        
        return lo;
    }
    
    public boolean canUseMinValue(int [] nums, int target) {
        int n = nums.length;
        long [] temp = new long [n];
        for (int i = n - 1; i >= 1; i--) {
            temp[i] += nums[i];
            long diff = temp[i] - target;
            if (diff <= 0) {
                continue;
            }
            
            temp[i] -= diff;
            temp[i - 1] += diff;
        }
        
        
        return (temp[0] + nums[0]) <= target;
    }
}