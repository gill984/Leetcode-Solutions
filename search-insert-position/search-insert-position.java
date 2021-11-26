class Solution
{
    public int searchInsert(int[] nums, int target)
    {
        int ip = Arrays.binarySearch(nums, target);
        if (ip < 0)
        {
            ip = -(ip + 1);
        }
        return ip;
    }
}