class Solution {
    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int sign = 1;
        for (int i : nums)
        {
            if (i == 0)
                return 0;
            if (i < 0)
                sign = sign * -1;
        }
        
        return sign;
    }
}