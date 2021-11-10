class Solution
{
    public int maxProfit(int[] prices)
    {
        int res = 0;
        int hold = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > hold)
            {
                res += prices[i] - hold;
                hold = prices[i];
            }
            else
            {
                hold = prices[i];
            }
        }
        
        return res;
    }
}