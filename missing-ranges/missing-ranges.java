class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int i = lower, ndx = 0; i <= upper; i++, ndx++)
        {
            if (ndx == nums.length)
            {
                res.add(translateToResult(i, upper));
                break;
            }
            else if (nums[ndx] != i)
            {
                res.add(translateToResult(i, nums[ndx] - 1));
                i = nums[ndx];
            }
        }
        
        return res;
    }
    
    public String translateToResult(int a, int b)
    {
        if (a == b)
            return ("" + a);
        else
            return (a + "->" + b);
    }
}