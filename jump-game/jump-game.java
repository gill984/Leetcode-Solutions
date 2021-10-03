class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        
        for (int i = 0; i < nums.length && i <= maxIdx; i++)
            maxIdx = Math.min(nums.length - 1, Math.max(i + nums[i], maxIdx));
        
        return (nums.length - 1 == maxIdx);
    }
}