class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Put all end times into a treemap and start times into a treemap
        // iterate through the end times treemap and remove the corresponding
        // start time element. If that element isn't the minimum, increment the
        // removal counter because some other value starts before or at this time
        // and ends after it. If there is a tie, in one of the maps, remove the
        // interval which is smaller right then and there.
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        TreeMap<Integer, Integer> ends = new TreeMap<>();
        int count = 0;
        
        for (int i = 0; i < intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!starts.containsKey(start) && !ends.containsKey(end))
            {
                starts.put(start, i);
                ends.put(end, i);
            }
            else if (starts.containsKey(start))
            {
                int j = starts.get(start);
                if (end >= intervals[j][1])
                {
                    starts.put(start, i);
                    ends.put(end, i);
                    ends.remove(intervals[j][1]);
                }
                count++;
            }
            else
            {
                int j = ends.get(end);
                if (start <= intervals[j][0])
                {
                    starts.put(start, i);
                    ends.put(end, i);
                    starts.remove(intervals[j][0]);
                }
                count++;
            }
            // System.out.println("starts: " + starts);
            // System.out.println("ends: " + ends);
        }
        
        for (int key : ends.keySet())
        {
            // System.out.println(key);
            int idx = ends.get(key);
            // System.out.println("Index: " + idx);
            if (starts.get(starts.firstKey()) != idx)
            {
                count++;
            }
            starts.remove(intervals[idx][0]);
        }
        
        return intervals.length - count;
    }
}