class Solution {
    private final int MINE = 1;
    private final int FREE = 0;
    private int n;
    
    public int orderOfLargestPlusSign(int n, int[][] mines)
    {
        this.n = n;
        int[][] grid = new int[n][n];
        for(int i = 0; i < mines.length; i++)
            grid[mines[i][0]][mines[i][1]] = MINE;
        
        int[][] closestMine = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(closestMine[i], Integer.MAX_VALUE);
        
        createDown(grid, closestMine);
        createUp(grid, closestMine);
        createRight(grid, closestMine);
        createLeft(grid, closestMine);
        
        // Pre-Process Arrays are all calculated now
        int res = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                res = Math.max(res, closestMine[i][j]);
        
        return res;
    }
    
    private void createDown(int[][] grid, int[][] closestMine)
    {
        for(int col = 0; col < grid[0].length; col++)
        {
            int last = n;
            for(int row = grid.length - 1; row >= 0; row--)
            {
                if(grid[row][col] == MINE)
                    last = row;
                closestMine[row][col] = Math.min(last - row, closestMine[row][col]);
            }
        }
    }
    
    private void createUp(int[][] grid, int[][] closestMine)
    {
        for(int col = 0; col < grid[0].length; col++)
        {
            int last = -1;
            for(int row = 0; row < grid.length; row++)
            {
                if(grid[row][col] == MINE)
                    last = row;
                closestMine[row][col] = Math.min(row - last, closestMine[row][col]);
            }
        }
    }
    
    private void createRight(int[][] grid, int[][] closestMine)
    {
        for(int row = 0; row < grid.length; row++)
        {
            int last = n;
            for(int col = grid[0].length - 1; col >= 0; col--)
            {
                if(grid[row][col] == MINE)
                    last = col;
                
                closestMine[row][col] = Math.min(closestMine[row][col], last - col);
            }
        }
    }
    
    private void createLeft(int[][] grid, int[][] closestMine)
    {
        for(int row = 0; row < grid.length; row++)
        {
            int last = -1;
            for(int col = 0; col < grid[0].length; col++)
            {
                if(grid[row][col] == MINE)
                    last = col;
                closestMine[row][col] = Math.min(closestMine[row][col], col - last);
            }
        }
    }
}