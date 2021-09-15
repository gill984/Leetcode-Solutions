class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] left = new int [n];
        int [] right = new int [n];
        
        int min = prices[0];
        int max = prices[n - 1];
        for (int i = 0; i < n; i++)
        {
            left[i] = Math.max(i > 0 ? left[i - 1] : 0, prices[i] - min);
            min = Math.min(prices[i], min);
            right[n - 1 - i] = Math.max(i > 0 ? right[n - i] : 0, max - prices[n - 1 - i]);
            max = Math.max(max, prices[n - 1 - i]);
        }
        
        int res = right[0];    // Best 1 transaction option, sometimes this is best
        
        for (int i = 0; i + 1 < n; i++)
            res = Math.max(res, left[i] + right[i + 1]);        // Best of all 2 transaction options
        
        return res;
    }
}