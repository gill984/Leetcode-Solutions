class Solution {
    final int ROW = 0;
    final int COL = 1;
    final int DISTANCE = 2;
    final int OBSTACLES = 3;
    int[][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (k >= m + n - 3)
            return m + n - 2;
        
        int [][] minRemoved = new int [m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(minRemoved[i], k + 1);
        
        Queue<int[]> paths = new ArrayDeque<int[]>();
        int [] start = new int [] {0, 0, 0, 0};
        paths.offer(start);
        
        while (!paths.isEmpty())
        {
            int[] p = paths.poll();
            for (int[] dir : dirs)
            {
                int nbrRow = p[ROW] + dir[ROW];
                int nbrCol = p[COL] + dir[COL];
                if (nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n)
                    continue;
                
                int[] nextPath = new int[] {nbrRow, nbrCol, p[DISTANCE] + 1,
                                            p[OBSTACLES] + (grid[nbrRow][nbrCol] == 1 ? 1 : 0)};
                
                if (nextPath[OBSTACLES] >= minRemoved[nbrRow][nbrCol])
                    continue;
                else
                    minRemoved[nbrRow][nbrCol] = nextPath[OBSTACLES];
                
                if (nextPath[ROW] == m - 1 && nextPath[COL] == n - 1)
                    return nextPath[DISTANCE];
                else
                    paths.offer(nextPath);                
            }
        }
        
        return -1;
    }
}