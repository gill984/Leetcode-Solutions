class Solution
{
    public int findJudge(int n, int[][] trust)
    {
        int [] trusted = new int [n];
        for (int [] t : trust)
        {
            int a = t[0] - 1;
            int b = t[1] - 1;
            trusted[a] -= 1;
            trusted[b] += 1;
        }
        
        int res = -1;
        for (int i = 0; i < trusted.length; i++)
        {
            if (res == -1 && trusted[i] == n - 1)
            {
                res = i + 1;
            }
            else if (res != -1 && trusted[i] == n - 1)
            {
                res = -1;
            }
        }
        
        return res;
    }
}