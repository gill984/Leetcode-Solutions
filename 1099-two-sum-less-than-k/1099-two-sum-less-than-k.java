class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int[] buckets = new int [1001];
        int lo = 1;
        int hi = Math.min(k - 2, 1000);
        int res = -1;
        
        for (int num : nums) {
            buckets[num] += 1;
        }
        
        while (lo <= hi) {
            if (lo + hi >= k || buckets[hi] == 0) {
                hi--;
                continue;
            } else if (buckets[lo] > 0 && buckets[hi] > 0 && hi != lo || buckets[lo] > 1){
                res = Math.max(res, lo + hi);
            }
            
            lo++;
        }
        
        return res;
    }
}