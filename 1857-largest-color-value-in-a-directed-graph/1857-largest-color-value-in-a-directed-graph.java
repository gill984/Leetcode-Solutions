class Solution {
    int n;
    int [][] memo;
    boolean [] visited;
    int res = -1;
    boolean containsCycle = false;
    List<List<Integer>> graph = new ArrayList<>();
    String colors;
    
    public int largestPathValue(String _colors, int[][] edges) {
        colors = _colors;
        n = colors.length();
        memo = new int [n][26];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int [] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        
        for (int i = 0; i < n && !containsCycle; i++) {
            boolean [] pathVisited = new boolean [n];
            dfs(i, pathVisited);
            
            for (int j : memo[i])
                res = Math.max(j, res);
        }
        
        return (containsCycle ? -1 : res);
    }
    
    public void dfs(int curr, boolean [] pathVisited) {
        if (visited[curr])
            return;
        
        visited[curr] = true;
        pathVisited[curr] = true;;
        
        for (int nbr : graph.get(curr)) {
            if (pathVisited[nbr]) {
                containsCycle = true;
                return;
            }
            
            dfs(nbr, pathVisited);
        }
        
        int [] maxes = new int [26];
        for (int i = 0; i < 26; i++)
            for (int nbr : graph.get(curr))
                maxes[i] = Math.max(maxes[i], memo[nbr][i]);
        
        maxes[colors.charAt(curr) - 'a'] += 1;
        for (int i = 0; i < 26; i++)
            memo[curr][i] = maxes[i];
        
        pathVisited[curr] = false;
    }
}