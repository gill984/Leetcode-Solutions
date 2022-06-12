class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int res = 0;
        Set<Integer> used = new HashSet<>();
        
        for (int lo = 0, hi = 0; hi < nums.length; hi++) {
            while (used.contains(nums[hi]) && lo < hi) {
                used.remove(nums[lo]);
                sum -= nums[lo];
                lo++;
            }
            used.add(nums[hi]);
            sum += nums[hi];
            res = Math.max(res, sum);
        }        
        
        return res;
    }
}