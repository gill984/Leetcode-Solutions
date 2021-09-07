class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        // Complete in at least maxtime but minimize passingFees
        int res = Integer.MAX_VALUE;
        int n = passingFees.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(i);
        
        for (int[] edge : edges)
        {
            nodes[edge[0]].addNeighbor(edge[1], edge[2]);
            nodes[edge[1]].addNeighbor(edge[0], edge[2]);
        }
        
        Path start = new Path(0, 0, passingFees[0]);
        PriorityQueue<Path> minPaths = new PriorityQueue<Path>();
        minPaths.offer(start);
        int [] minCost = new int[n];
        minCost[0] = passingFees[0];
        Arrays.fill(minCost, -1);
        
        while (!minPaths.isEmpty())
        {
            Path p = minPaths.poll();
            Node curNode = nodes[p.dest];
            
            if (minCost[p.dest] != -1 && minCost[p.dest] < p.cost)
                continue;
            else
                minCost[p.dest] = p.cost;
            
            // Candidate full path found
            if (p.dest == n - 1)
            {
                res = Math.min(res, p.cost);
                continue;
            }
            
            // Check all neighbors of this node
            for (int nbr : curNode.nbrTimes.keySet())
            {
                Path nbrPath = new Path(nbr, p.time + curNode.nbrTimes.get(nbr), p.cost + passingFees[nbr]);
                if (nbrPath.time <= maxTime)
                    minPaths.offer(nbrPath);
            }
        }
        
        if (res == Integer.MAX_VALUE)
            return -1;
        else
            return res;
    }
}

class Path implements Comparable<Path>
{
    int dest;
    int time;
    int cost;
    
    public Path (int d, int t, int c)
    {
        dest = d;
        time = t;
        cost = c;
    }
    
    // Primary sort by time, secondarily by cost
    public int compareTo(Path p)
    {
        if (time != p.time)
            return time - p.time;
        else
            return cost - p.cost;
    }
}

class Node
{
    int id;
    Map<Integer, Integer> nbrTimes;
    
    public Node (int ID)
    {
        id = ID;
        nbrTimes = new HashMap<Integer, Integer>();
    }
    
    public void addNeighbor(int nbrId, int time)
    {
        if (!nbrTimes.containsKey(nbrId) || time < nbrTimes.get(nbrId))
            nbrTimes.put(nbrId, time);
    }
}