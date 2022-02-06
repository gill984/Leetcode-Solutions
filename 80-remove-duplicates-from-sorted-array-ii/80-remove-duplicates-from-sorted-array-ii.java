class Solution {
    int DUPLICATES = 2;
    public int removeDuplicates(int[] nums) {        
        // lo is set to the index where we should swap in newly found integers
        // hi is the index which is being checked to see if it should be swapped to lo
        int lo = 0;
        int hi = 0;
        while(hi < nums.length)
        {
            // Count the number of duplicates here
            int cand = nums[hi];
            for(int count = 0; hi < nums.length && nums[hi] == cand; hi++)
            {
                count++;
                if(count <= DUPLICATES)
                {
                    nums[lo] = nums[hi];
                    lo++;
                }
            }
        }
        
        return lo;
    }
}