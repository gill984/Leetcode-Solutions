class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles)
            max = Math.max(max, p);
        
        // k can't be 0, and it at most is the max size in piles
        // because if k = max size of piles then we will trivially
        // finish in piles.length which is an optimal finish time
        int lo = 1;
        int hi = max;
        
        // Binary search for the best k
        int res = max;
        while (lo < hi)
        {
            int mid = (lo + hi) / 2;
            int hoursNeeded = findHoursNeeded(piles, mid);
            if (hoursNeeded > h)
                lo = mid + 1;
            else if (hoursNeeded <= h)
            {
                hi = mid;
                res = Math.min(res, mid);
            }
        }
        
        return res;
    }
    
    public int findHoursNeeded(int [] piles, int k)
    {
        int res = 0;
        for (int p : piles)
        {
            res += p / k;
            if (p % k != 0)
                res += 1;
        }
        return res;
    }
}