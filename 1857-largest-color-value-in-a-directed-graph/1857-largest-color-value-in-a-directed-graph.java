class Solution {
    int n;
    int [][] memo;
    boolean [] visited;
    int res = -1;
    Node[] nodes;
    boolean containsCycle = false;
    
    public int largestPathValue(String colors, int[][] edges) {
        n = colors.length();
        memo = new int [n][26];
        visited = new boolean[n];
        nodes = new Node[n];
        
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, colors.charAt(i));
        }
        
        for (int [] edge : edges) {
            nodes[edge[0]].neighbors.add(edge[1]);
            nodes[edge[1]].indegree++;
        }
        
        // Topological traversal
        for (int i = 0; i < n && !containsCycle; i++) {
            Node n = nodes[i];
            if (n.indegree != 0)
                continue;
            dfs(n, new HashSet<Integer>());
            
            for (int j : memo[i])
                res = Math.max(j, res);
        }
        
        // Check for an unvisited node, only possible with a cycle that doesn't have an
        for (boolean b : visited) {
            if (!b)
                containsCycle = true;
        }
        
        return (containsCycle ? -1 : res);
    }
    
    public void dfs(Node curr, Set<Integer> pathVisited) {
        // Traverse each neighbor then determine this nodes memo values from
        // all the neighbor memo values
        if (visited[curr.id])
            return;
        visited[curr.id] = true;
        pathVisited.add(curr.id);
        
        for (int nbr : curr.neighbors) {
            if (pathVisited.contains(nbr)) {
                containsCycle = true;
                return;
            }
            
            dfs(nodes[nbr], pathVisited);
        }
        
        int [] maxes = new int [26];
        for (int i = 0; i < 26; i++) {
            for (int nbr : curr.neighbors) {
                maxes[i] = Math.max(maxes[i], memo[nbr][i]);
            }
        }
        
        maxes[curr.color - 'a'] += 1;
        for (int i = 0; i < 26; i++) {
            memo[curr.id][i] = maxes[i];
        }
        pathVisited.remove(curr.id);
    }
    
    class Node {
        int id;
        char color;
        List<Integer> neighbors;
        int indegree;
        
        public Node (int _id, char c) {
            id = _id;
            color = c;
            neighbors = new ArrayList<>();
        }
    }
}