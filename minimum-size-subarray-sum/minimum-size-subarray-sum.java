class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int [] presum = new int [nums.length];
        
        // When created like this, presum is sorted
        for (int i = 0; i < n; i++)
            presum[i] = (i > 0 ? presum[i - 1] : 0) + nums[i];
        
        // sum(i, j) == presum[j] - presum[i] + nums[i]
        // target + presum[i] - nums[i] <= presum[j]
        // Search from i + 1 to n for the index j
        int res = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(presum));
        for (int i = 0; i < n; i++)
        {
            int search = target + (i > 0 ? presum[i - 1] : 0);
            // System.out.println(search);
            int index = Arrays.binarySearch(presum, i, n, search);
            
            if (index < 0)
            {
                index = (-(index + 1));
                // System.out.println(index);
                if (index == n)
                    continue;
            }
                
            
            res = Math.min(res, index - i + 1);
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}