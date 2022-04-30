class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build a graph which represents the relationship between each variable and the others
        // can be represented as an adjacency list
        Map<String, Node> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++)
        {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            graph.putIfAbsent(a, new Node(a));
            graph.putIfAbsent(b, new Node(b));
            graph.get(a).neighbors.add(graph.get(b));
            graph.get(b).neighbors.add(graph.get(a));
            graph.get(a).ratios.add(values[i]);
            graph.get(b).ratios.add(1.0 / values[i]);
        }
        
        // For each query dfs out
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            
            res[i] = (graph.containsKey(a) && graph.containsKey(b)) ? 
                dfs (graph.get(a), graph.get(b), 1.0, new HashSet<String>()) : -1.0;
        }
        
        return res;
    }
    
    private double dfs (Node curr, Node dest, double ratio, Set<String> visited)
    {
        if (curr == dest)
            return ratio;
        
        visited.add(curr.id);
        
        for (int i = 0; i < curr.neighbors.size(); i++)
        {
            Node nbr = curr.neighbors.get(i);
            if (visited.contains(nbr.id))
                continue;
            
            double res = dfs(nbr, dest, ratio * curr.ratios.get(i), visited);
            if (res != -1.0) {
                return res; 
            }
        }
        
        return -1.0;
    }
    
    class Node {
        String id;
        List<Node> neighbors;
        List<Double> ratios;
        
        public Node (String id) {
            neighbors = new ArrayList<>();
            ratios = new ArrayList<>();
            this.id = id;
        }
    }
}