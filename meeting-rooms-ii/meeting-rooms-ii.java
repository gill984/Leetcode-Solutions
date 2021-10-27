class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minEnd = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < intervals.length; i++)
        {
            if (minEnd.isEmpty() || intervals[i][0] < minEnd.peek())
            {
                minEnd.offer(intervals[i][1]);
                res = Math.max(res, minEnd.size());
            }
            else
            {
                while (!minEnd.isEmpty() && intervals[i][0] >= minEnd.peek())
                    minEnd.poll();
                minEnd.offer(intervals[i][1]);
            }
        }
        return res;
    }
}