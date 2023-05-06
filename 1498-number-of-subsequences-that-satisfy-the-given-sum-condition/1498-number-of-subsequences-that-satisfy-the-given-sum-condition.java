class Solution {
    int MOD = 1000000007;
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int hi = n - 1;
        int res = 0;
        
        int [] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i)
            power[i] = (power[i - 1] * 2) % MOD;
        
        for (int lo = 0; lo <= hi; lo++) {
            while (hi >= lo && nums[lo] + nums[hi] > target)
                hi--;
            
            if (hi < lo)
                break;
            
            res = (res + power[hi - lo]) % MOD;
        }
        
        return res;
    }
}