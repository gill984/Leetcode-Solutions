class Solution {
    public int minSwaps(int[] nums) {
        if(nums.length < 3)
            return 0;
        
        int numOnes = 0;
        for(int num: nums)
            if(num == 1)
                numOnes++;
        
        int count = 0;
        
        for (int i = 0; i < numOnes; i++)
            if (nums[i] == 1)
                count++;
        
        int res = numOnes - count;        
        for (int i = 1; i + numOnes - 1 < nums.length; i++) {
            if (nums[i - 1] == 1)
                count--;
            
            if (nums[i + numOnes - 1] == 1)
                count++;
            
            res = Math.min(numOnes - count, res);
        }
        
        return res;
    }
}