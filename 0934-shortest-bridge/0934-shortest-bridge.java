class Solution {
    int [][] dirs = new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    
    public int shortestBridge(int[][] grid) {
        // First have to find the islands. Then BFS out from both.
        m = grid.length;
        n = grid[0].length;
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        boolean searching = true;
        
        for (int row = 0; searching && row < m; row++) {
            for (int col = 0; searching && col < n; col++) {
                if (grid[row][col] == 1) {
                    markIsland(row, col, -1, bfsQueue, grid);
                    searching = false;
                }
            }
        }
        
        // for (int[] arr : bfsQueue) {
        //     System.out.println(Arrays.toString(arr));
        // }
        
        // System.out.println(Arrays.deepToString(grid));
        
        while (!bfsQueue.isEmpty()) {
            int [] node = bfsQueue.removeFirst();
            int row = node[0];
            int col = node[1];
            int distance = node[2];
            
            for (int [] dir : dirs) {
                int nbrRow = row + dir[0];
                int nbrCol = col + dir[1];
                
                // System.out.println(nbrRow + ", " + nbrCol);

                // Out of bounds guard clause
                if (nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n)
                    continue;

                if (grid[nbrRow][nbrCol] == 0) {
                    grid[nbrRow][nbrCol] = 2;
                    bfsQueue.addLast(new int [] {nbrRow, nbrCol, distance + 1});
                }

                if (grid[nbrRow][nbrCol] == 1) {
                    return distance;
                }
            }
        }
        
        return 0;
    }
    
    public void markIsland(int row, int col, int islandNum, Deque<int[]> bfsQueue, int[][] grid) {
        grid[row][col] = islandNum;
        
        for (int [] dir : dirs) {
            int nbrRow = row + dir[0];
            int nbrCol = col + dir[1];
            
            // Out of bounds guard clause
            if (nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n)
                continue;
            
            if (grid[nbrRow][nbrCol] == 0) {
                grid[nbrRow][nbrCol] = 2;
                bfsQueue.addLast(new int [] {nbrRow, nbrCol, 1});
            }
            
            if (grid[nbrRow][nbrCol] == 1) {
                markIsland(nbrRow, nbrCol, islandNum, bfsQueue, grid);
            }
        }
    }
}