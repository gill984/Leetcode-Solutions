class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;
        
        for (int i = 0; i < nums.length && i <= maxIdx && maxIdx < n - 1; i++)
        {
            maxIdx = Math.min(n - 1, Math.max(i + nums[i], maxIdx));
        }
        
        return (n - 1 == maxIdx);
    }
}