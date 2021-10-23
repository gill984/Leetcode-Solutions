class Solution {
    public int minCost(String ss, int[] cost) {
        char [] s = ss.toCharArray();
        int maxCost = 0;
        int res = 0;
        for (int i = 1; i < s.length; i++)
        {
            char prev = s[i - 1];
            char c = s[i];
            
            if (c == prev)
            {
                if (maxCost == 0)
                {
                    // this is the first duplicate for this sequence of duplicates
                    maxCost = Math.max(cost[i], cost[i - 1]);
                    res += Math.min(cost[i], cost[i - 1]);
                }
                else if (cost[i] > maxCost)
                {
                    res += maxCost;
                    maxCost = cost[i];
                }
                else
                {
                    res += cost[i];
                }
            }
            else
            {
                maxCost = 0;
            }
        }
        
        return res;
    }
}