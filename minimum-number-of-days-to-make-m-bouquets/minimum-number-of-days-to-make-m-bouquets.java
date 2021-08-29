class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Binary search for the correct day
        int min = 1;
        int max = (int)1E9;
        
        int lo = min;
        int hi = max;
        int result = -1;
        while (hi >= lo)
        {
            int mid = (hi + lo) / 2;
            boolean valid = canMakeBouquets(mid, bloomDay, m, k);
            if (valid)
            {
                hi = mid - 1;
                result = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return result;
    }
    
    boolean canMakeBouquets(int day, int [] bloomDay, int m, int k)
    {
        int bouquetCount = 0;
        int lo = 0;
        int hi = 0;
        
        while (hi < bloomDay.length)
        {
            if (bloomDay[hi] <= day)
            {
                if (hi - lo + 1 == k)
                {
                    bouquetCount++;
                    hi += 1;
                    lo = hi;
                }
                else
                {
                    hi += 1;
                }
            }
            else
            {
                hi++;
                lo = hi;
            }
        }
        return (bouquetCount >= m);
    }
}