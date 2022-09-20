class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int [nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; max = Math.max(max, dp[i][j]), j++)
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
        return max;
    }
}