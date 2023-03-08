class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = Integer.MAX_VALUE;
        int lo = 1;
        
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (canEat(mid, piles, h)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    public boolean canEat(int k, int [] piles, int h) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] / k + (piles[i] % k == 0 ? 0 : 1);
        }
        return time <= h;
    }
}