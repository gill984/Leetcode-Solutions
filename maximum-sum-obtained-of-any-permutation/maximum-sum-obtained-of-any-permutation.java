class Solution {    
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int [] counts = new int[n];
        
        for (int[] r : requests)
        {
            counts[r[0]] += 1;
            if (r[1] + 1 < n)
                counts[r[1] + 1] -= 1; 
        }
        
        for (int i = 1; i < n; i++)
            counts[i] = counts[i] + counts[i - 1];
        
        Arrays.sort(nums);
        Arrays.sort(counts);
        
        long res = 0;
        for (int i = n - 1; i >= 0 && counts[i] > 0 && nums[i] > 0; i--)
            res += (long) nums[i] * counts[i];
        
        return (int) (res % 1000000007);
    }
}