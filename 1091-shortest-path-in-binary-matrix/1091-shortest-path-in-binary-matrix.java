class Solution {
    int [][] dirs = new int [][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    int VISITED = 2;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        
        if (grid[0][0] == 0)
            bfsQueue.addLast(new int [] {0, 0, 1});
        
        while (!bfsQueue.isEmpty()) {
            int [] next = bfsQueue.removeFirst();
            int row = next[0];
            int col = next[1];
            int distance = next[2];
            
            if (grid[row][col] == VISITED) {
                continue;
            }
            
            grid[row][col] = VISITED;
            
            if (row == n - 1 && col == n - 1) {
                return distance;
            }
            
            for (int [] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n)
                    continue;
                
                if (grid[nextRow][nextCol] != 0)
                    continue;
                
                bfsQueue.addLast(new int [] {nextRow, nextCol, distance + 1});
            }
        }
        
        
        
        return -1;
    }
}