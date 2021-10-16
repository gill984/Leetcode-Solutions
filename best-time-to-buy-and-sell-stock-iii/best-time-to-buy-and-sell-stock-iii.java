class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] left = new int [n];
        int [] right = new int [n];
        
        int min = prices[0];
        int max = prices[n - 1];
        for (int i = 1; i < n; i++)
        {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
            right[n - 1 - i] = Math.max(right[n - i], max - prices[n - 1 - i]);
            max = Math.max(max, prices[n - 1 - i]);
        }
        
        // Best single transaction option. Sometimes 1 transaction is optimal.
        // left[n-1] = right[0] = max profit over [0..n-1] for 1 transaction
        int res = left[n - 1];
        
        // Since left[i] is the best profit we can get from [0..i] and
        // right[i] is the best profit we can get from [i..n-1]
        // We can now loop through and maximum of left[i] + right[i + 1]
        for (int i = 0; i + 1 < n; i++)
            res = Math.max(res, left[i] + right[i + 1]);
        
        return res;
    }
}