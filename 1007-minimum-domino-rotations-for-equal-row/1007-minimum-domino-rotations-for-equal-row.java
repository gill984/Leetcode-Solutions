class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int aSwaps = 0;
        int bSwaps = 0;
        
        int attempt = A[0];
        int aBothMatch = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] == attempt && B[i] == attempt)
            {
                aBothMatch += 1;
                continue;
            }
            else if (A[i] == attempt)
            {
                continue;
            }
            else if (B[i] == attempt)
            {
                aSwaps += 1;
            }
            else
            {
                aSwaps = -1;
                break;
            }
        }
        aSwaps = Math.min(aSwaps, A.length - aSwaps - aBothMatch);
        
        int bBothMatch = 0;
        attempt = B[0];
        for (int i = 0; i < B.length; i++)
        {
            if (A[i] == attempt && B[i] == attempt)
            {
                bBothMatch += 1;
                continue;
            }
            if (B[i] == attempt)
            {
                continue;
            }
            else if (A[i] == attempt)
            {
                bSwaps += 1;
            }
            else
            {
                bSwaps = -1;
                break;
            }
        }
        
        bSwaps = Math.min(bSwaps, B.length - bSwaps - bBothMatch);
        
        if (aSwaps == -1 && bSwaps == -1)
            return -1;
        else if (aSwaps == -1)
            return bSwaps;
        else if (bSwaps == -1)
            return aSwaps;
        else
            return Math.min(aSwaps, bSwaps);
    }
}