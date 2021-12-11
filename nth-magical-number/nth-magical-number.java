class Solution
{
    public int nthMagicalNumber(int n, int a, int b)
    {
        // Treat a as the larger number
        if (b < a)
        {
            int temp = a;
            a = b;
            b = temp;
        }
        
        int MOD = 1_000_000_007;
        int L = a / gcd(a, b) * b;
        
        long lo = 0;
        long hi = (long) n * Math.min(a, b);
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi / a + mi / b - mi / L < n)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }
    
    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}