class Solution {
    public int wiggleMaxLength(int[] nums) {
        int [] dpUp = new int [1001];
        int [] dpDown = new int [1001];
        int n = nums.length;
        
        if (nums == null || nums.length == 0)
            return 0;
        
        int res = 0;
        
        for (int i : nums) {
            dpUp[i] = Math.max(dpUp[i], 1);
            dpDown[i] = Math.max(dpDown[i], 1);
            
            for (int j = i + 1; j < 1001; j++) {
                if (dpUp[j] > 0) {
                    dpDown[i] = Math.max(dpDown[i], dpUp[j] + 1);
                }
            }
            
            for (int j = i - 1; j >= 0; j--) {
                if (dpDown[j] > 0) {
                    dpUp[i] = Math.max(dpUp[i], dpDown[j] + 1);
                }
            }
            
            res = Math.max(res, Math.max(dpDown[i], dpUp[i]));
        }
        
        return res;
    }
}