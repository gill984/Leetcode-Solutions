class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int index = 0;
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        while (index < n)
        {
            // System.out.println(Arrays.toString(nums));
            // System.out.println(res);
            
            if (nums[index] > 0)
            {
                int found = nums[index];
                if (nums[found - 1] == -1)
                {
                    res.add(found);
                    nums[index] = 0;
                    index++;
                }
                else if (found - 1 == index)
                {
                    nums[index] = -1;
                    index++;
                }
                else
                {
                    nums[index] = nums[found - 1];
                    nums[found - 1] = -1;
                }
            }
            else
            {
                index++;
            }
        }
        
        return res;
    }
}