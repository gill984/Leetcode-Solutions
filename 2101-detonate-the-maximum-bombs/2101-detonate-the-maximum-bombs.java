class Solution {
    int X = 0;
    int Y = 1;
    int RADIUS = 2;
    int n;
    List<List<Integer>> graph;
    int [][] bombs;
    
    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        n = bombs.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = graph.get(i);
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                double distance = calcDist(bombs[i], bombs[j]);
                if (distance <= bombs[i][2]) {
                    neighbors.add(j);
                }
            }
        }
        
        // Starting from each node, see how many bombs can be reached
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, new boolean [n]));
        }
        
        return res;
    }
    
    public int dfs (int node, boolean [] visited) {
        // Return how many new neighbors can be reached including this one
        if (visited[node])
            return 0;
        
        int res = 1;
        visited[node] = true;
        
        for (int nbr : graph.get(node)) {
            if (!visited[nbr])
                res += dfs(nbr, visited);
        }
        
        return res;
    }
    
    public double calcDist(int [] a, int [] b) {
        double xDist = a[0] - b[0];
        double yDist = a[1] - b[1];
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }
}