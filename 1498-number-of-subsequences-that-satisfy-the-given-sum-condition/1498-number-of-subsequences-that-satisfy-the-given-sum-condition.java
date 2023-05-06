class Solution {
    int MOD = 1000000007;
    
    public int numSubseq(int[] nums, int target) {        
        int n = nums.length;
        int res = 0;
        int [] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i)
            power[i] = (power[i - 1] * 2) % MOD;
        
        Arrays.sort(nums);
        
        for (int lo = 0, hi = n - 1; lo <= hi; lo++) {
            while (hi >= lo && nums[lo] + nums[hi] > target)
                hi--;
            
            if (hi >= lo)
                res = (res + power[hi - lo]) % MOD;
        }
        
        return res;
    }
}