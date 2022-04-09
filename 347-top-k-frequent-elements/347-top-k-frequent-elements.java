class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums)
            count.put(i, count.getOrDefault(i, 0) + 1);
        
        PriorityQueue<int[]> frequent = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        for (int num : count.keySet())
        {
            int [] pair = new int [] {num, count.get(num)};
            if (frequent.size() < k)
            {
                frequent.offer(pair);
            }
            else if (frequent.peek()[1] < pair[1])
            {
                frequent.poll();
                frequent.offer(pair);
            }
        }
        
        int [] res = new int [k];
        for (int i = 0; i < k; i++)
        {
            res[i] = frequent.poll()[0];
        }
        return res;
    }
}