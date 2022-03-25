class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort by difference between the two cities
        // 2 buckets, A preferred or B preferred
        // Match off the largest A preferred and B
        // preferred cities
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int res = 0;
        
        for (int [] cost : costs)
        {
            if (cost[0] < cost[1])
            {
                a.add(cost);
            }
            else
            {
                b.add(cost);
            }
        }
        
        Collections.sort(a, (x, y) -> (x[1] - x[0]) - (y[1] - y[0]));
        Collections.sort(b, (x, y) -> (x[0] - x[1]) - (y[0] - y[1]));
        
        while (!a.isEmpty() && !b.isEmpty())
        {
            res += a.remove(a.size() - 1)[0];
            res += b.remove(b.size() - 1)[1];
        }
        
        while (!a.isEmpty())
        {
            res += a.remove(a.size() - 1)[0];
            res += a.remove(0)[1];
        }
        
        while (!b.isEmpty())
        {
            res += b.remove(b.size() - 1)[1];
            res += b.remove(0)[0];
        }
        
        return res;
    }
}