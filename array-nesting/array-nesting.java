class Solution {
    final int VISITED = -1;
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int j = i;
            int count = 0;
            while (nums[j] != -1)
            {
                int temp = j;
                j = nums[j];
                count++;
                nums[temp] = -1;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}