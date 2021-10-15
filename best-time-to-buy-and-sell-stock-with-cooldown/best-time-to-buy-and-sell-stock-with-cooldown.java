class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] p = new int [n];
        int [] ph = new int [n];
        int [] h = new int [n];
        int res = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                h[i] = prices[i];
                continue;
            }
            
            // Better to keep holding with current hold profit
            // or take previous profit and buy new stock at current price?
            if (ph[i - 1] - h[i - 1] > p[i - 1] - prices[i])
            {
                ph[i] = ph[i - 1];
                h[i] = h[i - 1];
            }
            else
            {
                ph[i] = p[i - 1];
                h[i] = prices[i];
            }

            if (h[i - 1] < prices[i])
            {
                res = Math.max(res, ph[i - 1] + (prices[i] - h[i - 1]));

                if (i + 1 < n)
                    p[i + 1] = res;
            }
            
            p[i] = Math.max(p[i], p[i - 1]);
        }
        
        // System.out.println(Arrays.toString(p));
        // System.out.println(Arrays.toString(ph));
        // System.out.println(Arrays.toString(h));
        
        return res;
        
    }
}