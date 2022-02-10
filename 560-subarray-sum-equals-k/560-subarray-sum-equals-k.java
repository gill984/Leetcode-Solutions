class Solution {
    public int subarraySum(int[] nums, int k) {
        // Prefix sum problem
        // Maintain map from sum value of indices [0, i] to count of that value
        // For each value in nums
        //     Check how many subarrays prior to this can give a sum to k
        //     Then add the running sum including this num
        Map<Integer, Integer> sumCount = new HashMap<>();
        
        // Base case is that you can get to a sum of 0 with no elements
        sumCount.put(0, 1);
        
        // Running sum and result count
        int sum = 0;
        int count = 0;
        
        for (int i : nums)
        {
            sum += i;
            count += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}