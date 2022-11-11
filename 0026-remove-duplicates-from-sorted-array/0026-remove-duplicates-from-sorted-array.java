class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int duplicates = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicates++;
            } else {
                nums[i - duplicates] = nums[i];
            }
        }
        
        return n - duplicates;
    }
}