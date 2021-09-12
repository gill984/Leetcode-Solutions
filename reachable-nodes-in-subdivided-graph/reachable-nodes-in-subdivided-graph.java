class Solution {
    Map<Integer, Integer> reached;
    List<Map<Integer, Integer>> graph;
    int [] visited;
    int n;
    int res;
    int maxMoves;
    
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.n = n;
        this.maxMoves = maxMoves;
        res = 0;
        reached = new HashMap<>();
        graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            graph.add(new HashMap<>());
        
        for (int[] e : edges)
        {
            graph.get(e[0]).put(e[1], e[2]);
            graph.get(e[1]).put(e[0], e[2]);
            reached.put(hash(e[0], e[1]), 0);
            reached.put(hash(e[1], e[0]), 0);
        }
        
        visited = new int[n];
        Arrays.fill(visited, -1);
        
        dijkstra();
        
        return res;
    }
    
    public void dijkstra()
    {
        PriorityQueue<Path> pq = new PriorityQueue<Path>(n, (a, b) -> a.moves - b.moves);
        pq.add(new Path(0, 0));
        
        while (!pq.isEmpty())
        {
            // System.out.println(pq);
            Path p = pq.poll();
            int node = p.node;
            int moves = p.moves;
            
            // Either it's the first time we've been to this node,
            // we've been here with more moves made and should continue,
            // or we've been here with fewer moves made and need to stop
            if (visited[node] == -1) {
                res += 1;
                visited[node] = moves;
            }
            else if (visited[node] > moves)
            {
                visited[node] = moves;
            } 
            else
            {
                continue;
            }

            // For each neighbor of n, nbr; determine if we can reach that nbr and how many unreached
            // subdivided nodes we can reach between n and nbr
            int movesRemaining = maxMoves - moves;
            Map<Integer, Integer> neighbors = graph.get(node);
            for (int nbr : neighbors.keySet())
            {
                // First determine how many subdivided nodes we can reach and add them
                int distance = neighbors.get(nbr);
                int reachedFromN = reached.get(hash(node, nbr));
                int reachedFromNbr = reached.get(hash(nbr, node));
                int nodesRemaining = Math.max(distance - reachedFromN - reachedFromNbr, 0);

                if (nodesRemaining > 0)
                {
                    int newNodes = Math.min(movesRemaining - reachedFromN, nodesRemaining);
                    reached.put(hash(node, nbr), reachedFromN + newNodes);
                    res += newNodes;
                }

                if (movesRemaining >= distance + 1 && visited[nbr] == -1 || visited[nbr] > moves + distance + 1)
                {
                    pq.offer(new Path(nbr, moves + distance + 1));
                }
            }
        }
    }
    
    public int hash(int from, int to)
    {
        return (from) + (to * n);
    }
    
    class Path
    {
        int node;
        int moves;
        
        public Path(int id, int m)
        {
            node = id;
            moves = m;
        }
        
        public String toString()
        {
            return "Node: " + node + ", moves: " + moves; 
        }
    }
}