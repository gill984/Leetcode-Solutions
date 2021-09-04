class Solution {
    final int COUNT = 0;
    final int DIST = 1;
    Node[] nodes;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges)
    {
        nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i);
        for (int i = 0; i < edges.length; i++)
        {
            nodes[edges[i][0]].nbr.put(edges[i][1], new int[2]);
            nodes[edges[i][1]].nbr.put(edges[i][0], new int[2]);
        }
        
        // Do the dfs operation from an arbitrary root
        // this fills out every node's neighbor map
        // in the direction opposite of the root
        Node root = nodes[0];
        for (int i : root.nbr.keySet())
            dfs(-1, root.id);
        
        // for (Node iter : nodes)
        //     System.out.println(iter);
        
        // Now that every node has its neighbor map filled
        // out in the opposite direction of the root, fill
        // in the gaps
        int [] res = new int[n];
        dfsFill(-1, root.id, res, 0, 0);
        
        return res;
    }
    
    public void dfsFill(int from, int to, int[] res, int trailCount, int trailSum)
    {
        // System.out.println("from: " + from + ", to: " + to + ", trailCount: " + trailCount + ", trailSum: " + trailSum);
        int count = 1 + trailCount;
        int sum = trailSum + trailCount;
        Node n = nodes[to];
        for (int k : n.nbr.keySet())
        {
            count += n.nbr.get(k)[COUNT];
            sum += n.nbr.get(k)[DIST];            
        }
        
        res[to] = sum;
        for (int k : n.nbr.keySet())
        {
            if (k != from) {
                dfsFill(n.id, k, res, count - n.nbr.get(k)[COUNT], sum - n.nbr.get(k)[DIST]);
            }
                
        }
    }
    
    public int[] dfs(int from, int to)
    {
        Node n = nodes[to];
        int [] result = new int[2];
        result[COUNT] = 1;
        for (int i : n.nbr.keySet())
        {
            // Don't go back to where we came from
            if (i == from)
                continue;
            
            int [] nbrRes = dfs(to, i);
            nbrRes[DIST] += nbrRes[COUNT];
            n.nbr.put(i, nbrRes);
            result[COUNT] += nbrRes[COUNT];
            result[DIST] += nbrRes[DIST];
        }
        
        return result;
    }
    
    class Node
    {
        int id;
        Map<Integer, int[]> nbr;
        
        public Node (int ID)
        {
            id = ID;
            nbr = new HashMap<Integer, int[]>();
        }
        
        public String toString()
        {
            StringBuilder s = new StringBuilder();
            s.append("id: " + id + ", nbr: ");
            for (int i : nbr.keySet())
                s.append(i + "=" + Arrays.toString(nbr.get(i)));
            return s.toString();
        }
    }
}