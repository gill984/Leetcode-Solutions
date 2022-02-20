public class Solution {
    public int RemoveCoveredIntervals(int[][] intervals) {
        Array.Sort(intervals, (a, b) => a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);
        int end = 0;
        int res = intervals.Length;
        
        foreach (int [] i in intervals)
        {
            if (i[1] > end)
                end = i[1];
            else
                res--;
        }
        
        return res;
    }
}