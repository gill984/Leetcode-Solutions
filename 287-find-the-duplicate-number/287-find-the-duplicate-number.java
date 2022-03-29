class Solution {
    public int findDuplicate(int[] nums) {
        // Put each number in it's index location
        // if the correct number is already there, this is the duplicate
        // store the extra number in the original location
        int idx = 0;
        int n = nums.length - 1;
        
        while (idx < n + 1)
        {
            int num1 = nums[idx];
            if (num1 - 1 != idx)
            {
                int num2 = nums[num1 - 1];
                if (num2 == num1)
                {
                    return num1;
                }
                else
                {
                    nums[idx] = num2;
                    nums[num1 - 1] = num1;
                }
            }
            else
            {
                idx++;
            }
        }
        
        return 0;
    }
}