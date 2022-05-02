class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenIdx = 0;
        int n = nums.length;
        for (int i = 0; i < n;) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[evenIdx];
                nums[evenIdx] = temp;
                if (evenIdx == i) {
                    i++;
                }
                evenIdx++;
            } else {
                i++;
            }
        }
        
        return nums;
    }
}