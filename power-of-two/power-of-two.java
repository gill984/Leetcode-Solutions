class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        
        boolean power = false;
        for (int i = 0; i < 32; i++)
        {
            if ((1 << i & n) != 0)
            {
                if (power)
                    return false;
                else
                    power = true;
            }
        }
        
        return power;
    }
}