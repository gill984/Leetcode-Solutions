class Solution {
    final int NONE = 100000;
    
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> numPoints = new TreeMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            numPoints.putIfAbsent(nums[i], 0);
            numPoints.put(nums[i], numPoints.get(nums[i]) + nums[i]);
        }
        
        int res = 0;
        int prev = NONE;
        List<Integer> adjacentValues = new ArrayList<Integer>();
        for (int k : numPoints.navigableKeySet())
        {
            int v = numPoints.get(k);
            if (prev == NONE)
            {
                adjacentValues.add(v);
            }
            else if (k == prev + 1)
            {
                adjacentValues.add(v);
            }
            else
            {
                res += findBest(adjacentValues);
                adjacentValues.clear();
                adjacentValues.add(v);
            }
            
            prev = k;
        }
        
        if (adjacentValues.size() != 0)
            res += findBest(adjacentValues);
        
        return res;
    }
    
    public int findBest(List<Integer> values)
    {
        int [] dp = new int [values.size()];
        
        // dp[i] == max value at this index possible
        // dp[i] == Max of dp[i - 1] and values[i] + dp[i - 2]
        for (int i = 0; i < dp.length; i++)
        {
            if (i == 0)
                dp[i] = values.get(i);
            else if (i == 1)
                dp[i] = Math.max(dp[i - 1], values.get(i));
            else
                dp[i] = Math.max(values.get(i) + dp[i - 2], dp[i - 1]);
        }
        
        return dp[dp.length - 1];
    }
}