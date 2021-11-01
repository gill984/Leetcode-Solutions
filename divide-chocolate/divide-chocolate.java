class Solution {
    int n;
    public int maximizeSweetness(int[] sweetness, int kMinusOne)
    {
        int k = kMinusOne + 1;
        n = sweetness.length;
        int res = 0;
        
        int left = 1;
        int right = n * 100000;
        
        while (left < right)
        {
            int mid = (right - left) / 2 + left;
            int minSweetness = validMinimum(mid, sweetness, k);
            
            if (minSweetness == -1)
            {
                right = mid;
            }
            else
            {
                res = Math.max(minSweetness, res);
                left = minSweetness + 1;
            }
        }
        
        return res;
    }
    
    // Return actual minimum sweetness here, -1 if it is impossible to achieve
    public int validMinimum(int minSweetness, int [] sweetness, int k)
    {
        int res = Integer.MAX_VALUE;
        int idx = 0;
        
        for (int i = 0; i < k; i++)
        {
            int piece = 0;
            for (; idx < n && piece < minSweetness; idx++)
            {
                piece += sweetness[idx];
            }
            
            if (piece < minSweetness)
                return -1;
            else
                res = Math.min(res, piece);
        }
        
        return res;
    }
}