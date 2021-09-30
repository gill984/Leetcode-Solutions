class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        // Can tell what the sum should be by averaging all values
        int sum = 0;
        for (int i : nums)
            sum += i;
        
        // If sum isn't evenly divisible by k, this won't work
        if (sum % k != 0)
            return false;
        
        int target = sum / k;
        
        if (nums[n - 1] > target)
            return false;
        
        Arrays.sort(nums);
        
        return dfs(nums, 0, 0, k, target, 0, new HashMap<>());
    }
    
    public boolean dfs(int[] nums, int count, int sum, int k, int target, int visited, Map<Integer, Boolean> memo)
    {
        int n = nums.length;
        
        if (count + 1 == k)
        {
            return true;
        }
        
        if (sum > target)
        {
            return false;
        }
        
        if (memo.containsKey(visited))
        {
            return memo.get(visited);
        }
        
        if (sum == target)
        {
            boolean res = dfs (nums, count + 1, 0, k, target, visited, memo);
            memo.put(visited, res);
            return res;
        }
        
        for (int i = n - 1; i >= 0; i--)
        {
            if ((visited & (1 << i)) == 0)
            {
                visited = (visited ^ (1 << i));
                
                // Try this out
                if (dfs(nums, count, sum + nums[i], k, target, visited, memo))
                    return true;
                
                // If that didn't work
                visited = (visited ^ (1 << i));
            }
        }
        
        memo.put(visited, false);
        return false;
    }
}