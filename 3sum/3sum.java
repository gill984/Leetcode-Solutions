class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || nums[i - 1] != nums[i])
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
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo - 1] == nums[lo])
                            lo++;
                    }
                }
            }
        }
        
        return res;
    }
}