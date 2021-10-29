class Solution {
    int [][] dirs = new int [][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // int[] {row, col, distance}
        Queue<int[]> pointQ = new ArrayDeque<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2)
                    pointQ.offer(new int [] {i, j, 0});
        
        int res = 0;
        while (!pointQ.isEmpty())
        {
            int [] point = pointQ.poll();
            res = Math.max(res, point[2]);
            
            for (int[] dir : dirs)
            {
                int nextRow = point[0] + dir[0];
                int nextCol = point[1] + dir[1];
                
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1)
                {
                    grid[nextRow][nextCol] = 2;
                    pointQ.offer(new int [] {nextRow, nextCol, point[2] + 1});
                }                    
            }
        }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    return -1;
        
        return res;
    }
}