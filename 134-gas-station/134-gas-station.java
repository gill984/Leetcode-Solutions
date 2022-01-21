class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++)
        {
            int margin = gas[start] - cost[start];
            if (margin < 0)
            {
                continue;
            }
            
            // Can't stop at end because there might not be a solution
            for (int end = (start + 1) % n; ; end = ((end + 1) % n))
            {
                margin += gas[end] - cost[end];
                if (margin < 0)
                {
                    if (end < start)
                    {
                        return -1;
                    }
                    
                    start = end;
                    break;
                }
                else if (end == Math.floorMod(start - 1, n))
                {
                    return start;
                }
            }
        }
        
        return -1;
    }
}