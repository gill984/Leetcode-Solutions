class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0, res = 0;
        boolean [] used = new boolean [10001];
        
        for (int lo = 0, hi = 0; hi < nums.length; hi++) {
            while (used[nums[hi]] && lo < hi) {
                used[nums[lo]] = false;
                sum -= nums[lo];
                lo++;
            }
            used[nums[hi]] = true;
            sum += nums[hi];
            res = Math.max(res, sum);
        }        
        
        return res;
    }
}