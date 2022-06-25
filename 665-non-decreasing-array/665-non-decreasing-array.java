class Solution {
    public boolean checkPossibility(int[] nums) {
        // Try replacing previous first, if that won't work
        // try replacing current
        int n = nums.length;
        boolean usedModify = false;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            
            if (usedModify) {
                return false;
            } else if (i < 2 || nums[i - 2] <= nums[i]) {
                nums[i - 1] = (i >= 2 ? nums[i - 2] : Integer.MIN_VALUE);
                usedModify = true;
            } else {
                nums[i] = nums[i - 1];
                usedModify = true;
            }
        }
        
        return true;
    }
}