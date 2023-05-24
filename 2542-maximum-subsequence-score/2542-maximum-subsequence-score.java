class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        // Gradually allow smaller and smaller minimums
        PriorityQueue<Integer> multipliers = new PriorityQueue<>();
        int [][] nums = new int [n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        
        // Descending nums2 order, i.e. in order of largest min to smallest min
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        long sum = 0;
        long min = Long.MAX_VALUE;
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i][1]);
            if (multipliers.size() < k) {
                multipliers.offer(nums[i][0]);
                sum += nums[i][0];
            } else if (nums[i][0] > multipliers.peek()) {
                sum -= multipliers.poll();
                sum += nums[i][0];
                multipliers.offer(nums[i][0]);
            }
            
            if (i >= k - 1)
                res = Math.max(res, sum * min);
        }
        
        return res;
    }
}