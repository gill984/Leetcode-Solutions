class Solution {
    int [] count;
    int [] res;
    List<Set<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges)
    {
        count = new int[n];
        res = new int[n];
        tree = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++)
            tree.add(new HashSet<Integer>());
        for (int[] edge : edges)
        {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        // Do the dfs1 operation from an arbitrary root 0. This fills
        // out every node's count and result but only in the direction
        // that the dfs traversed in.
        dfs1(-1, 0);
        
        // At this point res and count only take into account nodes
        // which are in the opposite direction of the path to root
        // for each node i. Meaning res[0] is the only correct value right now.
        // This correct result can be propagated back out in the following way:
        // From the root, look at all neighbors, their res[nbr] should be
        // equal to the result at this node shifted +1 for each node which is
        // closer to the neighbor, and shifted -1 for each node which is farther
        // away from the neighbor than the root. There are count[nbr] nodes
        // closer to the neighbor than the root and there are n - count[nbr]
        // nodes which are further from the neighbor than the root. This gives
        // us this equation res[nbr] = res[root] - count[nbr] + count.length - count[nbr]
        dfs2(-1, 0);
        return res;
    }
    
    public void dfs1(int from, int to)
    {        
        for (int i : tree.get(to))
        {
            if (i == from)
                continue;
            dfs1(to, i);
            count[to] += count[i];
            res[to] = res[to] + res[i] + count[i];
        }
        count[to] += 1;
    }
    
    public void dfs2(int from, int to)
    {
        for (int nbr : tree.get(to))
        {
            if (nbr == from)
                continue;
            
            res[nbr] = res[to] - count[nbr] + count.length - count[nbr];
            dfs2(to, nbr);
        }
    }
}