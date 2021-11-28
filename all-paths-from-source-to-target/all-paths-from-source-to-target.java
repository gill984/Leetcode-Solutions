class Solution
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        // From node 0 to node n-1
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        
        dfs(0, graph, res, path, visited);
        return res;
    }
    
    public void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> path, Set<Integer> visited)
    {
        if (node == graph.length - 1)
        {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        int [] neighbors = graph[node];
        for (int nbr : neighbors)
        {
            if (!visited.contains(nbr))
            {
                visited.add(nbr);
                path.add(nbr);
                dfs(nbr, graph, res, path, visited);
                path.remove(path.size() - 1);
                visited.remove(nbr);
            }
        }
    }
}