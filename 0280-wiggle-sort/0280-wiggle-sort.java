class Solution {
    public void wiggleSort(int[] nums) {
        int [] buckets = new int [10001];
        for (int num : nums)
            buckets[num]++;
        
        int lo = 0;
        int hi = 10000;
        int idx = 0;
        while (idx < nums.length) {
            while (buckets[lo] == 0)
                lo++;
            while (buckets[hi] == 0)
                hi--;
            int cand = (idx % 2 == 0 ? lo : hi);
            
                
            buckets[cand]--;
            nums[idx] = cand;
            idx++;
        }
    }
}