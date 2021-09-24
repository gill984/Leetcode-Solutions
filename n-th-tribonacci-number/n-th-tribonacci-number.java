class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        
        int [] tri = new int [n + 1];
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;
        for (int i = 3; i <= n; i++)
        {
            tri[i] = tri[i - 3] + tri[i - 2] + tri[i - 1];
        }
        
        return tri[n];
    }
}