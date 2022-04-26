class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Minimum spanning tree problem
        // cost of path is manhattan distance between points
        int n = points.length;
        int [][] d = new int [n][n];
        boolean [] visited = new boolean[n];
        int curr = 0;
        int count = 1;
        visited[curr] = true;
        int res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        
        while (count < n)
        {
            visited[curr] = true;
            
            // Add all edges which connect to points not in the MST
            for (int i = 0; i < n; i++)
            {
                if (i == curr)
                    continue;
                
                minHeap.offer(new int [] {i, manhattan(points[curr], points[i])});
            }
            
            while (!minHeap.isEmpty())
            {
                int [] cand = minHeap.poll();
                if (!visited[cand[0]])
                {
                    curr = cand[0];
                    res += cand[1];
                    count++;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public int manhattan(int [] a, int [] b)
    {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}