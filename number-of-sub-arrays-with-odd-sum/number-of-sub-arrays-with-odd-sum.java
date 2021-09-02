class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int [] oddEnds = new int [n + 1];
        int [] evenEnds = new int [n + 1];
        int MOD = 1000000007;
        
        for (int i = 1; i < n + 1; i++)
        {
            if (arr[i - 1] % 2 == 0)
            {
                evenEnds[i] = evenEnds[i - 1] + 1;
                oddEnds[i] = oddEnds[i - 1];
            }
            else
            {
                evenEnds[i] = oddEnds[i - 1];
                oddEnds[i] = evenEnds[i - 1] + 1;
            }
        }
        
        int res = 0;
        for (int o : oddEnds)
            res = (res + o) % MOD;
        return res;
    }
}