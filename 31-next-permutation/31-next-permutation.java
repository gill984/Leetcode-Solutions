class Solution
{
    public void nextPermutation(int[] nums)
    {
        // Pick up penultimate number in permutation, going down
        //     Check to see if this number can be swapped with any of the previously checked numbers
        //     This number should be swapped with the smallest number which is larger than this number
        //     If no swap exists, bubble sort this entry into the end of the list.
        //     If swap is available, perform swap and then sort end of list
        int swappedIndex = -1;
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            swappedIndex = swapWithClosestLarger(nums, i);
            
            if(swappedIndex == -1)
            {
                Arrays.sort(nums, i, nums.length);
                continue;
            }
            else
            {
                // Swap has occurred, merge sort remaining elements
                Arrays.sort(nums, swappedIndex + 1, nums.length);
                return;
            }
        }
        
        // Swap was never found, sort array and return in for lexicographically smallest permutation
        Arrays.sort(nums);
        return;
    }
    
    // Return -1 if no swap found
    public int swapWithClosestLarger(int[] arr, int index)
    {
        int value = arr[index];
        
        for(int i = index + 1; i < arr.length; i++)
        {
            // Looking for a value which is less than the current index
            // Swap if found
            if(arr[i] > value )
            {
                int temp = arr[i];
                arr[i] = value;
                arr[index] = temp;
                return i;
            }
        }
        
        return -1;
    }
}