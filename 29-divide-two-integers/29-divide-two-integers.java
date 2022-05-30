class Solution
{
    public int divide(int dividend, int divisor)
    {
        if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0)
            return Integer.MAX_VALUE;
        else if (dividend == 0)
            return 0;
        else if (divisor == 1)
            return dividend;
        
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;
        
        int quotient = 0;
        int bigDivisor = divisor;
        int mult = -1;
        
        while (dividend <= divisor)
        {
            if (dividend - bigDivisor <= 0)
            {
                quotient += mult;
                dividend -= bigDivisor;
                
                if (bigDivisor >= (Integer.MIN_VALUE >> 1))
                {
                    bigDivisor += bigDivisor;
                    mult += mult;
                }
            }
            else
            {
                bigDivisor >>= 1;
                mult >>= 1;
            }
        }
        
        if (sign)
            return -quotient;
        else
            return quotient;
    }
}