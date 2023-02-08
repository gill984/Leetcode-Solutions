class Solution {
    public void wiggleSort(int[] nums) {
        int [] buckets = new int [10001];
        for (int num : nums)
            buckets[num]++;
        
        int lo = 0;
        int hi = 10000;
        int idx = 0;
        while (idx < nums.length) {
            int cand = 0;
            if (idx % 2 == 0) {
                while (buckets[lo] == 0)
                    lo++;
                cand = lo;
            } else {
                while (buckets[hi] == 0)
                    hi--;
                cand = hi;
            }
            buckets[cand]--;
            nums[idx] = cand;
            idx++;
        }
    }
}