class Solution {
    final int NONE = 100000;
    
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<int[]> numScore = new ArrayList<int[]>();
        int res = 0;
        List<Integer> sequence = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (numScore.size() == 0)
            {
                numScore.add(new int [] {nums[i], nums[i]});
            }
            else if (numScore.get(numScore.size() - 1)[0] == nums[i])
            {
                numScore.get(numScore.size() - 1)[1] += nums[i];
            }
            else
            {
                sequence.add(numScore.get(numScore.size() - 1)[1]);
                
                if (numScore.get(numScore.size() - 1)[0] + 1 != nums[i])
                {
                    res += findBest(sequence);
                    sequence.clear();
                }
                
                numScore.add(new int [] {nums[i], nums[i]});
            }
            
            if (i == nums.length - 1)
                sequence.add(numScore.get(numScore.size() - 1)[1]);
        }
        
        res += findBest(sequence);
        
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
        
        System.out.println(Arrays.toString(dp));
        
        return dp[dp.length - 1];
    }
}