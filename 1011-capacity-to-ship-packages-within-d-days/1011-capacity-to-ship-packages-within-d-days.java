class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        
        int lo = 0;
        int hi = 0;
        
        for (int i : weights) {
            lo = Math.max(lo, i);
            hi += i;
        }
        
        int res = hi;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canShip(mid, weights, days)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return res;
    }
    
    public boolean canShip(int shipCapacity, int[] weights, int days) {
        int j = 0;
        for (int i = 0; i < days; i++) {
            int curShip = shipCapacity;
            for (; j < weights.length; j++) {
                curShip -= weights[j];
                if (curShip < 0) {
                    break;
                }
            }
        }
        
        return j == weights.length;
    }
}