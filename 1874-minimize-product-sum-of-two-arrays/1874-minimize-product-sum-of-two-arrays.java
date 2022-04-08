class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int [] bucket1 = new int [100];
        int [] bucket2 = new int [100];
        int n = nums1.length;
        
        for (int i = 0; i < n; i++)
        {
            bucket1[nums1[i] - 1]++;
            bucket2[nums2[i] - 1]++;
        }
        
        int res = 0;
        int lo = 0;
        int hi = 99;
        
        for (int i = 0; i < n; i++)
        {
            // move lo and hi to next available bucket
            while (bucket1[lo] == 0)
                lo++;
            while (bucket2[hi] == 0)
                hi--;
            
            res += (hi + 1) * (lo + 1);
            bucket1[lo]--;
            bucket2[hi]--;
        }
        
        return res;
    }
}