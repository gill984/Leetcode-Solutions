class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int medianIndex = nums.length / 2;
        int median = nums[medianIndex];
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += Math.abs(nums[i] - median);
        
        return sum;
    }
}