class Solution {
    int n;
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.n = n;
        Map<Integer, Integer> reached = new HashMap<>();
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        boolean [] visited = new boolean[n];
        int res = 0;
        
        for (int i = 0; i < n; i++)
            graph.add(new HashMap<>());
        
        for (int[] e : edges)
        {
            graph.get(e[0]).put(e[1], e[2]);
            graph.get(e[1]).put(e[0], e[2]);
            reached.put(hash(e[0], e[1]), 0);
            reached.put(hash(e[1], e[0]), 0);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> a[1] - b[1]);
        pq.add(new int[] {0, 0});
        
        while (!pq.isEmpty())
        {
            int[] p = pq.poll();
            int node = p[0];
            int moves = p[1];
            
            if (visited[node])
                continue;

            res += 1;
            visited[node] = true;
            int movesRemaining = maxMoves - moves;
            Map<Integer, Integer> neighbors = graph.get(node);
            for (int nbr : neighbors.keySet())
            {
                int d = neighbors.get(nbr);
                int reachedFromN = reached.get(hash(node, nbr));
                int reachedFromNbr = reached.get(hash(nbr, node));
                int nodesRemaining = d - reachedFromN - reachedFromNbr;

                if (nodesRemaining > 0)
                {
                    int newReached = Math.min(movesRemaining - reachedFromN, nodesRemaining);
                    reached.put(hash(node, nbr), reachedFromN + newReached);
                    res += newReached;
                }

                if (movesRemaining >= d + 1 && !visited[nbr])
                    pq.offer(new int[] {nbr, moves + d + 1});
            }
        }
        
        return res;
    }
    
    public int hash(int from, int to)
    {
        return (from) + (to * n * 1007);
    }
}