class Solution {
    public void nextPermutation(int[] nums) {
        // From right to left, look for first occurence of a decrease
        // sort from index where decrease appears to the end of the array
        // if no decrease is found, return fully sorted array
        int n = nums.length;
        PriorityQueue<Integer> trail = new PriorityQueue<>();
        trail.offer(nums[n - 1]);
        
        for (int i = n - 2; i >= 0; i--)
        {
            // Check for decrease
            if (nums[i] < nums[i + 1])
            {
                Arrays.sort(nums, i + 1, n);
                for (int j = i + 1; j < n; j++)
                {
                    if (nums[j] > nums[i])
                    {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                break;
            }
            else if (i == 0)
                Arrays.sort(nums);
        }
    }
}