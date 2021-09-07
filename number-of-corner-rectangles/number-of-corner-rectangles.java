class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Number of pairs of columns in rows
        // if count[i][j] = 2 then there are 2 rows
        // above which have column i and j set to 1
        int[][] count = new int[n][n];
        int res = 0;
        
        for (int i = 0; i < m; i++)
        {
            for (int lo = 0; lo < n; lo++)
            {
                if (grid[i][lo] == 1)
                {
                    for (int hi = lo + 1; hi < n; hi++)
                    {
                        if (grid[i][hi] == 1)
                        {
                            res += count[lo][hi];
                            count[lo][hi] += 1;
                        }
                    }
                }
            }
        }
        
        return res;
    }
}