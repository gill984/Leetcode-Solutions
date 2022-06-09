class Solution {
    public int minSwaps(int[] nums) {
        if(nums.length < 3)
            return 0;
        
        int numOnes = 0;
        for(int num: nums) {
            if(num == 1)
                numOnes++;
        }
        
        int lo = 0;
        int hi = numOnes - 1;
        int count = 0;
        
        for (int i = 0; i <= hi; i++)
            if (nums[i] == 1)
                count++;
        
        int res = numOnes - count;        
        while (hi + 1 < nums.length) {
            if (nums[lo++] == 1)
                count--;
            
            if (nums[++hi] == 1)
                count++;
            
            res = Math.min(numOnes - count, res);
        }
        
        return res;
    }
}