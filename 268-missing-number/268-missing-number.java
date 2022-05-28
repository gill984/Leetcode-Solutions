class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Swap the numbers into the correct index
        // swap to index val - 1, swap 0 into zdx
        for (int i = 0; i < n;) {
            if (nums[i] == i + 1 || nums[i] == 0) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        for (int i = 0; i < n; i++)
            if (nums[i] == 0)
                return i + 1;
        
        return 0;
    }
}