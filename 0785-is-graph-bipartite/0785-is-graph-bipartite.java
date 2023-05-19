class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for (int i = 0; i < graph.length; i++)
        {
            if (!set1.contains(i) && !set2.contains(i))
                if(!dfsBipartite(graph, i, set1, set2, true))
                    return false;
        }
        
        return true;
    }
    
    public boolean dfsBipartite(int[][] graph, int node, Set<Integer> set1, Set<Integer> set2, boolean inSet1)
    {
        if (inSet1)
            set1.add(node);
        else
            set2.add(node);
        int [] neighbors = graph[node];
        for (int neighbor : neighbors)
        {
            if (inSet1)
            {
                if (set1.contains(neighbor))
                    return false;
                else if (set2.contains(neighbor))
                    continue;
                else if(!dfsBipartite(graph, neighbor, set1, set2, false))
                    return false;
            }
            else
            {
                if (set2.contains(neighbor))
                    return false;
                else if(set1.contains(neighbor))
                    continue;
                else if(!dfsBipartite(graph, neighbor, set1, set2, true))
                    return false;
            }
        }
        
        return true;
    }
}