class Solution {
    public int findMaxLength(int[] nums) {
        // Use a prefix sum algorithm
        // consider a 1 as +1, 0 as -1
        // Store prefix sum in a map
        
        // Want 0 = sum(0, i - 1) - sum(0, j), where j > i
        
        // Map from each sum to the original occurence
        Map<Integer, Integer> sumToFirstIndex = new HashMap<>();
        sumToFirstIndex.put(0, -1);
        
        int sum = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            // System.out.println(sumToFirstIndex);
            int val = nums[i];
            sum = sum + (val == 1 ? 1 : -1);
            
            // Look for -sum in the prefix map
            if (sumToFirstIndex.containsKey(sum))
            {
                int prevIdx = sumToFirstIndex.get(sum);
                res = Math.max(res, i - prevIdx);
            }
            else
            {
                sumToFirstIndex.put(sum, i);
            }
        }
        
        return res;
    }
}