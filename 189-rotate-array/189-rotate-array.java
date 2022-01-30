class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0)
            return;
        
        int [] result = new int[nums.length];
        int idx = nums.length - k;
        for (int i = 0; i < nums.length; i++)
        {
            result[i] = nums[idx];
            idx = (idx + 1) % nums.length;
        }
        
        for (int i = 0; i < nums.length; i++)
            nums[i] = result[i];
    }
}