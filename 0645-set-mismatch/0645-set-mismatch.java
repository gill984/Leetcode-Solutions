class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int [] count = new int [n];
        for (int i : nums) {
            count[i - 1] += 1;
        }
        
        int [] res = new int [] {0, 0};
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                res[1] = i + 1;
            } else if (count[i] == 2) {
                res[0] = i + 1;
            }
        }
        
        return res;
    }
}