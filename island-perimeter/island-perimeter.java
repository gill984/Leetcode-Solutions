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
                    p += 4;
                    
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) // UP
                        p -= 2;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) // LEFT
                        p -= 2;
                }
            }
        }
        
        return p;
    }
}