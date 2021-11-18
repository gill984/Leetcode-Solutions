class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        
        // Swap each number to its correct location
        for (int idx = 0; idx < n; )
        {
            if (nums[idx] == 0)
            {
                idx++;
            }
            else if (nums[idx] == idx + 1)
            {
                idx++;
            }
            else
            {
                int temp = nums[nums[idx] - 1];
                
                if (temp == nums[idx])
                {
                    nums[idx] = 0;
                }
                else
                {
                    nums[nums[idx] - 1] = nums[idx];                
                    nums[idx] = temp;
                }
            }
        }
        
        for (int i = 0; i < n; i++)
            if (nums[i] == 0)
                res.add(i + 1);
        
        return res;
    }
}