class Solution {
    public int singleNumber(int[] nums) {
        int [] bits = new int [32];
        
        for (int i : nums)
        {
            for (int b = 0; b < bits.length; b++)
            {
                if ((i & (1 << b)) != 0)
                {
                    bits[b] = (bits[b] + 1) % 3;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < bits.length; i++)
        {
            if (bits[i] == 1)
            {
                res = (res | (1 << i));
            }
        }
        
        return res;
    }
}