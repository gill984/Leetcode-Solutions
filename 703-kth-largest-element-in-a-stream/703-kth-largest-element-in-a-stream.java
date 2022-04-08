class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        for (int i : nums)
        {
            if (minHeap.size() < k)
            {
                minHeap.offer(i);
            }
            else if (minHeap.peek() < i)
            {
                minHeap.poll();
                minHeap.offer(i);
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k)
        {
            minHeap.offer(val);
        }
        else if (minHeap.peek() < val)
        {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}