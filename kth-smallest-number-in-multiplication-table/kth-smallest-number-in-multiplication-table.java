class Solution
{
    public int findKthNumber(int m, int n, int k)
    {
        int lo = 1;
        int hi = m * n;
        
        while (lo < hi)
        {
            int mid = (hi - lo) / 2 + lo;
            if (enough(mid, m, n, k))
            {
                hi = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    public boolean enough(int guess, int m, int n, int k)
    {
        int count = 0;
        for (int i = 1; i <= m; i++)
        {
            count += Math.min(guess / i, n);
        }
        return count >= k;
    }
}