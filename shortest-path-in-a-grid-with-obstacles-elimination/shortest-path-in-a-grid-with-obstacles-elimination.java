class Solution {
    final int ROW = 0;
    final int COL = 1;
    final int DISTANCE = 2;
    final int OBSTACLES = 3;
    int[][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1)
            return 0;
        
        int [][] minRemoved = new int [m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(minRemoved[i], k + 1);
        
        // {row, col, distance, obstaclesRemoved}
        Queue<int[]> paths = new ArrayDeque<int[]>();
        int [] start = new int [] {0, 0, 0, 0};
        paths.offer(start);
        
        while (!paths.isEmpty())
        {
            int[] p = paths.poll();
            
            for (int[] dir : dirs)
            {
                // Try going up, down, left, and right based on obstacles
                int nbrRow = p[ROW] + dir[ROW];
                int nbrCol = p[COL] + dir[COL];
                
                // Check for out of bounds
                if (nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n)
                    continue;
                
                int[] nextPath = new int[] {nbrRow, nbrCol, p[DISTANCE] + 1,
                                            p[OBSTACLES] + (grid[nbrRow][nbrCol] == 1 ? 1 : 0)};
                
                // Check if we have visited this spot using fewer obstacles already
                // if yes then don't try going down this path. If not then update
                // the minimum number of obstacles to reach this spot to this next
                // path's obstacle count. This also checks if we have gone over
                // the alloted removals because we initialize to k + 1.
                if (nextPath[OBSTACLES] >= minRemoved[nbrRow][nbrCol])
                    continue;
                else
                    minRemoved[nbrRow][nbrCol] = nextPath[OBSTACLES];
                
                // The first time we reach the end is the fastest possible
                // way to reach the end because we do a BFS
                if (nextPath[ROW] == m - 1 && nextPath[COL] == n - 1)
                    return nextPath[DISTANCE];
                else
                    paths.offer(nextPath);                
            }
        }
        
        return -1;
    }
}