class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        for (int i = 0; i < n; i++)
            res += nums1[i] * nums2[n - 1 - i];
        return res;
    }
}