class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Let's say we're trying out values from a certain starting position
        // if we find that this position doesn't work, can skip to the next position which comes after a negative margin position.
        // Where margin[i] = gas[i] - cost[i].
        // Can skip those other values because this value doesn't work and provides a positive margin.
        // Can all values up to the current endpoint be skipped?
        
        // If an index j exists s.t. j > i and j < k, where k is the current end point which causes negative margin.
        // Then j also cannot be the starting point, because the cumulative margin at j is >= 0 in order to reach k,
        // so all values i-k are eliminated as possible starting points
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