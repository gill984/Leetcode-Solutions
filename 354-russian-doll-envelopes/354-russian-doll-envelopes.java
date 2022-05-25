class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // extract the second dimension and run LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            heights[i] = envelopes[i][1];
        }
        
        return lengthOfLIS(heights);
    }
    
    public int lengthOfLIS(int [] heights) {
        // dp[i] = smallest max number in sequence of length i
        int [] dp = new int [heights.length];
        int len = 0;
        for (int h : heights) {
            int i = Arrays.binarySearch(dp, 0, len, h);
            if (i < 0) {
                i = -(i + 1);
            }
            
            dp[i] = h;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
