class Solution
{
    final double FAIL = -1.0;
    public double minmaxGasDist(int[] stations, int k)
    {
        int n = stations.length;
        double hi = 0.0;
        double lo = (stations[n - 1] - stations[0]) / (1.0 * n + k);
        for (int i = 0; i + 1 < n; i++)
            hi = Math.max(hi, stations[i + 1] - stations[i]);
        
        double res = hi;
        while (lo < hi)
        {
            double mid = (lo + hi) / 2;
            double fits = attemptDistance(mid, stations, k);
            if (fits == FAIL)
            {
                lo = mid;
            }
            else
            {
                res = Math.min(res, fits);
                hi = mid;
                if ((hi - lo) < 0.000001)
                    return res;
            }
        }
        
        return res;
    }
    
    public double attemptDistance(double d, int[] stations, int k)
    {
        int added = 0;
        double res = 0.0;
        
        for (int i = 0; i + 1 < stations.length; i++)
        {
            int add = stationsToAdd(stations[i], stations[i + 1], d);
            added += add;
            if (added > k)
                return FAIL;
            else
                res = Math.max(res, (stations[i + 1] - stations[i]) / (1.0 + add));
        }
        
        return res;
    }
    
    public int stationsToAdd(int s, int e, double t)
    {
        double res = Math.ceil((e - s) / t - 1);
        return (int) res;
    }
}