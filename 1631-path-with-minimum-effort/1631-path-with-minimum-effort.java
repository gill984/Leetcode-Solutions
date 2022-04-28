class Solution {
    int [][] dirs = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minimumEffortPath(int[][] heights) {
        // Dijkstra's, pick up minimal effort piece
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int [] start = new int [] {0, 0, 0};
        pq.offer(start);
        
        int [][] min = new int [m][n];
        for (int[] a : min)
            Arrays.fill(a, -1);
        
        while (!pq.isEmpty())
        {
            int [] curr = pq.poll();
            
            if (curr[0] == m - 1 && curr[1] == n - 1)
            {
                return curr[2];
            }
            
            for (int [] dir : dirs)
            {
                int nbrRow = curr[0] + dir[0];
                int nbrCol = curr[1] + dir[1];
                
                if (nbrRow >= 0 && nbrRow < m && nbrCol >= 0 && nbrCol < n)
                {
                    int cost = Math.max(curr[2], Math.abs(heights[nbrRow][nbrCol] - heights[curr[0]][curr[1]]));
                    if (min[nbrRow][nbrCol] > cost || min[nbrRow][nbrCol] == -1)
                    {
                        pq.offer(new int [] {nbrRow,
                                             nbrCol,
                                             cost
                                            });
                        min[nbrRow][nbrCol] = cost;
                    }
                }
            }
        }
        
        return -1;
    }
}