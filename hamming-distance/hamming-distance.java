class Solution
{
    public int hammingDistance(int x, int y)
    {
        int res = 0;
        int h = x ^ y;
        for (int i = 0; i < 31; i++)
            if ((h & 1 << i) != 0)
                res++;
        
        return res;
    }
}