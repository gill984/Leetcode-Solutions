class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int [] even = new int [n / 2];
        int [] odd = new int [n / 2];
        
        int evenIdx = 0;
        int oddIdx = 0;
        
        for (int i : nums)
        {
            if (i % 2 == 0)
                even[evenIdx++] = i;
            else
                odd[oddIdx++] = i;
        }
        
        for (int i = 0; i < nums.length; i += 2)
        {
            nums[i] = even[i / 2];
            nums[i + 1] = odd[i / 2];
        }
        
        return nums;
    }
}