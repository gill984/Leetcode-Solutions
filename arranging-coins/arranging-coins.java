class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        for (int i = 1; (n - i) >= 0; i++)
        {
            n -= i;
            res++;
        }
        
        return res;
    }
}