class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Check each bit
        // 1. Is either bit in left or right a 0
        int res = left & right;
        
        // 2. Will that bit change to 0 when incrementing up to right?
        int clearFrom = -1;
        int hi = -1;
        for (int shift = 30; shift >= 0; shift--)
        {
            if (hi == -1 && (right & 1 << shift) > 0)
            {
                hi = shift;
                System.out.println(hi);
            }
            
            if (hi != -1 && (left & 1 << shift) == 0 && (right & 1 << shift) > 0)
            {
                System.out.println(clearFrom);
                clearFrom = shift;
                break;
            }
        }
        
        System.out.println(clearFrom);
        
        for (int i = clearFrom; i >= 0; i--)
        {
            System.out.println(Integer.toString(0x7FFFFFFF ^ (1 << i), 2));
            res = (res & (0xFFFFFFFF ^ (1 << i)));
            System.out.println(res);
        }
        
        return res;
    }
}