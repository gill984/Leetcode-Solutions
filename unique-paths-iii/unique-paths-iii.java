class Solution {
    private final int START = 1;
    private final int END = 2;
    private final int OBSTACLE = -1;
    private final int VISITED = 3;
    
    public int uniquePathsIII(int[][] grid) {        
        // Can easily find a single path from start to end using dfs or bfs
        // Trick here is that we need to walk over every non-obstacle square exactly once
        // Can perform dfs, each time we reach the end, add 1
        // Mark and unmark visited as we go
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        int numToVisit = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    startRow = i;
                    startCol = j;
                }
                else if(grid[i][j] == 2)
                {
                    endRow = i;
                    endCol = j;
                }
                
                if(grid[i][j] != -1)
                {
                    numToVisit++;
                }
            }
        }
        
        return dfs(grid, startRow, startCol, endRow, endCol, 0, numToVisit);
    }
    
    public int dfs(int[][] grid, int row, int col, int endRow, int endCol, int numVisited, int numToVisit)
    {
        if(grid[row][col] == END)
        {
            if(numVisited == numToVisit - 1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        grid[row][col] = VISITED;
        numVisited++;
        
        // Try going up left down and right
        int [] rowOffsets = new int [] {-1, 1, 0, 0};
        int [] colOffsets = new int [] {0, 0, -1, 1};
        int numPaths = 0;
        
        for(int i = 0; i < rowOffsets.length; i++)
        {
            int rOff = rowOffsets[i];
            int cOff = colOffsets[i];
            if(row + rOff >= 0 && row + rOff < grid.length && col + cOff >= 0 && col + cOff < grid[0].length &&
               grid[row + rOff][col + cOff] != OBSTACLE && grid[row + rOff][col + cOff] != VISITED)
            {
                numPaths += dfs(grid, row + rOff, col + cOff, endRow, endCol, numVisited, numToVisit);
            }
        }
        
        // Mark this spot as unvisited again
        grid[row][col] = 0;
        
        return numPaths;
    }
}