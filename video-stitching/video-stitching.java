class Solution {
    public int videoStitching(int[][] clips, int time) {
        // sort by starting time
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int maxEnd = 0;
        int idx = 0;
        int count = 0;
        
        while (idx < clips.length && maxEnd < time)
        {
            int nextEnd = maxEnd;
            while (idx < clips.length && clips[idx][0] <= maxEnd)
            {
                nextEnd = Math.max(nextEnd, clips[idx][1]);
                idx++;
            }
            
            if (nextEnd == maxEnd)
                return -1;
            
            maxEnd = nextEnd;
            count++;
        }
        
        if (maxEnd < time)
            return -1;
        else
            return count;
    }
}