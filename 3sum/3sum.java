class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || nums[i] != nums[i - 1])
            {
                int lo = i + 1;
                int hi = n - 1;
                
                while (lo < hi)
                {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < 0)
                    {
                        lo++;
                    }
                    else if (sum > 0)
                    {
                        hi--;
                    }
                    else
                    {
                        res.add(List.of(nums[i], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        
                        while (lo < hi && nums[lo] == nums[lo - 1])
                            lo++;
                    }
                }
            }
        }
        
        return res;
    }
}