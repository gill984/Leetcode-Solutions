class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort in ascending order by start time, descending order by end time
        // that way the bigger intervals with the same start time are considered first
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);
        int end = 0;
        int res = intervals.length;
        
        for (int [] i : intervals)
        {
            if (i[1] > end)
            {
                end = i[1];
            }
            else
            {
                res--;
            }
        }
        
        return res;
    }
}