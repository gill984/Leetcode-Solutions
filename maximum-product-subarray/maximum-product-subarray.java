class Solution {
    public int maxProduct(int[] nums) {
        // Keep track of largest positive and largest negative value at each
        // array index
        int n = nums.length;
        int max = nums[0];
        
        // Largest positive and negative subarrays ending at nums[i]
        int [] pos = new int [n];
        int [] neg = new int [n];
        
        if (nums[0] > 0)
            pos[0] = nums[0];
        else
            neg[0] = nums[0];
        
        for (int i = 1; i < n; i++)
        {
            int num = nums[i];
            if (num > 0)
            {
                pos[i] = Math.max(pos[i - 1] * num, num);
                neg[i] = neg[i - 1] * num;
            }
            else
            {
                pos[i] = neg[i - 1] * num;
                neg[i] = Math.min(pos[i - 1] * num, num);
            }
            
            max = Math.max(max, pos[i]);
        }
        
        return max;
    }
}