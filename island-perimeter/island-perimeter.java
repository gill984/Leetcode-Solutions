class Solution {
    public int islandPerimeter(int[][] grid) {
        // Find a piece of land and dfs out
        int m = grid.length;
        int n = grid[0].length;
        int p = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    if (i - 1 < 0 || grid[i - 1][j] == 0) // UP
                        p++;
                    if (j - 1 < 0 || grid[i][j - 1] == 0) // LEFT
                        p++;
                    if (i + 1 >= m || grid[i + 1][j] == 0) // DOWN
                        p++;
                    if (j + 1 >= n || grid[i][j + 1] == 0) // RIGHT
                        p++;
                }
            }
        }
        
        return p;
    }
}