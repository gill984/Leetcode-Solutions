class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // Build graph
        for (int i = 0; i < pid.size(); i++) {
            int node = pid.get(i);
            int parent = ppid.get(i);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(node);
        }
        
        List<Integer> res = new ArrayList<>();
        dfs(graph, kill, res);
        return res;
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, int node, List<Integer> res) {
        res.add(node);
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(graph, child, res);
        }
    }
}