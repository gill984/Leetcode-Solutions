class Solution {
    public int maxResult(int[] nums, int k) {
        // DP plus deque: T = O(n)
        int n = nums.length;
        Deque<Integer> maxPrevIdx = new ArrayDeque<>();
        maxPrevIdx.addFirst(0);
        for (int i = 1; i < n; i++) {
            // Always jump from first deque element
            while (maxPrevIdx.peekFirst() < i - k)
                maxPrevIdx.removeFirst();
                        
            nums[i] += nums[maxPrevIdx.peekFirst()];
            while (!maxPrevIdx.isEmpty() && nums[i] >= nums[maxPrevIdx.peekLast()])
                maxPrevIdx.removeLast();
            maxPrevIdx.addLast(i);
        }
        
        return nums[n - 1];
    }
}