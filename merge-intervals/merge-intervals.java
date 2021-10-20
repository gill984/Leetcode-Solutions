class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort by start time
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int [] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++)
        {
            int [] next = intervals[i];
            if (cur[1] >= next[0])
                cur[1] = Math.max(next[1], cur[1]);
            else
            {
                mergedIntervals.add(cur);
                cur = next;
            }
        }
        mergedIntervals.add(cur);
        
        int[][] res = new int [mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++)
            res[i] = mergedIntervals.get(i);
            
        
        return res;
    }
}