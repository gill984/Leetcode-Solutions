class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // Use a sliding window algorithm, continue sliding until
        // series is no longer arithmetic. Number of arithmetic series
        // 3 -> 1, 4 -> 3, 5 -> 6, 6 -> 10, ...
        // x = (l - 1) * (l - 2) / 2
        if (nums.length < 3)
            return 0;
        
        int lo = 0;
        int hi = 1;
        int diff = nums[hi] - nums[lo];
        int res = 0;
        
        while (hi + 1 < nums.length)
        {
            if (nums[hi + 1] - nums[hi] == diff)
            {
                hi++;
                if (hi == nums.length - 1)
                    res += arith(hi - lo + 1);
            }
            else
            {
                res += arith(hi - lo + 1);
                lo = hi;
                hi = hi + 1;
                diff = nums[hi] - nums[lo];
            }
        }
        
        return res;
    }
    
    public int arith(int n)
    {
        return (n >= 3 ? (n - 1) * (n - 2) / 2 : 0);
    }
}