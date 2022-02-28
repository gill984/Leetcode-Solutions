class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < nums.length;)
        {
            int j = i;
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1])
                j++;
            
            if (i == j)
                res.add("" + nums[i]);
            else
                res.add(nums[i] + "->" + nums[j]);
            
            i = j + 1;
        }
        
        return res;
    }
}