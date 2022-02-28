class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < nums.length;)
        {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1)
                j++;
            j -= 1;
            
            if (i == j)
            {
                res.add("" + nums[i]);
            }
            else
            {
                res.add(nums[i] + "->" + nums[j]);
            }
            
            i = j + 1;
        }
        
        return res;
    }
}