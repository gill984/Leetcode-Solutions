class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> preSumToIndex = new HashMap<>();
        int sum = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (sum == k)
            {
                res = i + 1;
            }
            else if (preSumToIndex.containsKey(-k + sum))
            {
                int index = preSumToIndex.get(-k + sum);
                res = Math.max(res, i - index);
            }
            
            preSumToIndex.putIfAbsent(sum, i);
        }
        
        return res;
    }
}