class Solution {
    public int maxResult(int[] nums, int k) {
        // use dynamic programming
        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        maxHeap.offer(new int [] {0, nums[0]});
        for (int i = 1; i < n; i++) {
            // Try jumping to this index from all indices [i-k, i-1]
            while (maxHeap.peek()[0] < i - k)
                maxHeap.poll();
            
            int [] to = new int [] {i, maxHeap.peek()[1] + nums[i]};
            nums[i] = to[1];
            maxHeap.offer(to);
        }
        
        return nums[n - 1];
    }
}