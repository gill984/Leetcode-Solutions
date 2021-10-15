class Solution {

    int [] nums;
    Random r;
    
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if (nums == null)
            return null;
        
        int [] s = nums.clone();
        for (int i = 0; i < s.length; i++)
        {
            int j = r.nextInt(s.length);
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        
        return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */