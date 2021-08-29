class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean removed = false;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] <= nums[i - 1])
            {
                if (removed)
                {
                    return false;
                }
                else
                {
                    // Check if we can remove one of the 2 possible offenders
                    // if we can, update i to go past this issue
                    if (i + 1 >= nums.length || nums[i - 1] < nums[i + 1])
                    {
                        removed = true;
                        
                        // We are removing index i, so add 1 so that we don't check it again
                        i += 1;
                    }
                    else if (i - 2 < 0 || nums[i - 2] < nums[i])
                    {
                        removed = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}