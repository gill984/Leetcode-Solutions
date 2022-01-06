class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Sort on increasing from locations
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> minTo = new PriorityQueue<int[]>(10, (a, b) -> a[2] - b[2]);
        int passengers = 0;
        
        for (int i = 0; i < trips.length; i++)
        {
            int[] next = trips[i];
            
            // Remove all previous trips which can drop off their passengers
            while (!minTo.isEmpty() && minTo.peek()[2] <= next[1])
            {
                int [] t = minTo.poll();
                passengers -= t[0];
            }
            
            // Try adding this new trip back on
            passengers += next[0];
            minTo.offer(next);
            if (passengers > capacity)
                return false;
        }
        
        return true;
    }
}