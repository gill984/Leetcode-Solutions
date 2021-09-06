class Solution {
    public int findDerangement(int n) {
        long [] d = new long [n + 1];
        long term = 1;
        long MOD = 1000000007L;
        
        for (int i = 2; i <= n; i++)
        {
            d[i] = ((d[i - 1] * i) % MOD + term) % MOD;
            term = -term;
        }
        
        return (int) d[n];
    }
}