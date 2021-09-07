class Solution {
    public int findPoisonedDuration(int[] timeSeries, int d) {
        int lo = timeSeries[0];
        int hi = lo + d;
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++)
        {
            if (hi < timeSeries[i])
            {
                res = res + hi - lo;
                lo = timeSeries[i];
                hi = lo + d;
            }
            else
            {
                hi = timeSeries[i] + d;
            }
        }
        
        res += hi - lo;
        
        return res;
    }
}