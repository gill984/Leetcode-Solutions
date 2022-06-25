class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean usedModify = false;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            
            if (usedModify) {
                return false;
            } else if (i < 2 || nums[i - 2] <= nums[i]) {
                usedModify = true;
            } else {
                nums[i] = nums[i - 1];
                usedModify = true;
            }
        }
        
        return true;
    }
}