class Solution
{
    public int subarraySum(int[] nums, int k)
    {
        // Seems like a prefix sum problem
        // O(n^2) is the obvious naive solution (find all subarrays) which is too slow for 10^4 input
        int n = nums.length;
        
        // sum[i] = sum(nums[0], ..., nums[i])
        // Then given integers i and j, and i < j
        // k = sum(nums[i], ..., nums[j]) = sum[j] - sum[i - 1]
        // Map out previous sums (0, ..., j - 1) counts
        // Lookup -(k - sum[j]) and add the count
        int sum = 0;
        Map<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
        sumCount.put(0, 1);
        int res = 0;
        
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
            res += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}