class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long hi = 100000000000000L;
        long lo = 1;
        
        while (hi >= lo) {
            long mid = lo + (hi - lo) / 2;
            if (isEnoughTime(mid, time, totalTrips))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        
        return lo;
    }
    
    public boolean isEnoughTime(long timeAllowed, int [] time, long totalTrips) {
        long trips = 0;
        for (int t : time)
            trips += timeAllowed / t;
        return trips >= totalTrips;
    }
}