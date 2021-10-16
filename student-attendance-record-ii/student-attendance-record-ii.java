class Solution
{
    int MOD = 1000000007;
    
    public int checkRecord(int n)
    {
        if (n == 1)
            return 3;
        
        int [] A = new int [n];         // A[i] = L_NO_A[i - 1] + P_NO_A[i - 1]
        int [] L = new int [n];         // L[i] = P[i - 1] + A[i - 1] + L[i - 1] - L[i - 2]
        int [] P = new int [n];         // P[i] = P[i - 1] + L[i - 1] + A[i - 1]
        int [] L_NO_A = new int [n];    // L_NO_A[i] = P_NO_A[i - 1] + P_NO_A[i - 2]
        int [] P_NO_A = new int [n];    // P_NO_A[i] = P_NO_A[i - 1] + L_NO_A[i - 1]
        
        A[0] = 1;
        L[0] = 1;
        L[1] = 3;
        P[0] = 1;
        L_NO_A[0] = 1;
        L_NO_A[1] = 2;
        P_NO_A[0] = 1;         
        
        for (int i = 1; i < n; i++)
        {
            A[i] = (L_NO_A[i - 1] + P_NO_A[i - 1]) % MOD;
            if (i >= 2)
                L[i] = ((P[i - 1] + A[i - 1]) % MOD + (A[i - 2] + P[i - 2])% MOD)% MOD;
            P[i] = ((P[i - 1] + L[i - 1]) % MOD + A[i - 1]) % MOD;
            
            if (i >= 2)
                L_NO_A[i] = (P_NO_A[i - 1] + P_NO_A[i - 2])% MOD;
            P_NO_A[i] = (P_NO_A[i - 1] + L_NO_A[i - 1]) % MOD;
        }
        
        return ((A[n - 1] + L[n - 1]) % MOD + P[n - 1]) % MOD;
    }
}