class Solution {
    // UP, DOWN, LEFT, RIGHT
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int UNVISITED = 0;
    final int VISITED = 1;
    
    // ocean consts
    final int NONE = 0;
    final int ATLANTIC = 1;
    final int PACIFIC = 2;
    final int BOTH = 3;
    
    // From every cell on the edge, DFS out and mark cells as reaching the different oceans
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] reach = new int[m][n];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int ocean = NONE;
                if (i == 0 || j == 0)
                    ocean += PACIFIC;
                if (i == m - 1 || j == n - 1)
                    ocean += ATLANTIC;
                    
                if (ocean != NONE)
                    dfs(m, n, i, j, heights, reach, result, ocean);
            }
           
        }
        
        return result;
    }
    
    public void dfs(int m, int n, int row, int col, int[][] heights, int[][] reach, List<List<Integer>> result, int ocean)
    {        
        if (reach[row][col] == NONE)
            reach[row][col] = ocean;
        else if (reach[row][col] == ocean || reach[row][col] == BOTH)
            return;
        else
            reach[row][col] = BOTH;
        
        if (reach[row][col] == BOTH)
        {
            List<Integer> resultEntry = new ArrayList<Integer>();
            resultEntry.add(row);
            resultEntry.add(col);
            result.add(resultEntry);
        }
        
        for (int d = 0; d < dirs.length; d++)
        {
            int nbrRow = dirs[d][0] + row;
            int nbrCol = dirs[d][1] + col;
            if (nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n)
                continue;
            if (heights[row][col] <= heights[nbrRow][nbrCol])
                dfs(m, n, nbrRow, nbrCol, heights, reach, result, ocean);
        }
    }
}


















