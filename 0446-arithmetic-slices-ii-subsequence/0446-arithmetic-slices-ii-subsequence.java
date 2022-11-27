class Solution {    
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            dp.add(new HashMap<>());
            for (int j = 0; j < i; j++)
            {
                if((long)nums[i] - nums[j] > Integer.MAX_VALUE)
                    continue;
                else if((long)nums[i] - nums[j] < Integer.MIN_VALUE)
                    continue;
                
                int diff = nums[i] - nums[j];
                int count = dp.get(j).getOrDefault(diff, 0);
                res += count;
                dp.get(i).put(diff, dp.get(i).getOrDefault(diff, 0) + count + 1);
            }
        }
        
        return res;
    }
}