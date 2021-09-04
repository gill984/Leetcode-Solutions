class Solution
{
    int START = 0;
    int END = 1;
    
    public int eraseOverlapIntervals(int[][] intervals)
    {
        // Sort by start, secondarily by end
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        
        int count = 0;
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length;)
        {
            int [] interval = intervals[i];
            i += 1;
            while (i < intervals.length && intervals[i][0] == interval[0]) {
                i++;
                count++;
            }
                
            list.add(interval);
        }
        
        for (int i = 0; i + 1 < list.size();)
        {
            if (list.get(i)[END] > list.get(i + 1)[START])
            {
                if (list.get(i)[END] >= list.get(i + 1)[END])
                    list.remove(i);
                else
                    list.remove(i + 1);
                count++;
            }
            else
                i++;
        }
        
        
        return count;
    }
}