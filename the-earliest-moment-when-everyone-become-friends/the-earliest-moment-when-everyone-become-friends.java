class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // Can think of as a graph where we add connections
        // When does graph only have 1 connected component?
        // It becomes connected when n - 1 nodes in separate
        // connected components are unioned
        // Can check if such a union is occurring during the
        // union operation by checking root of both components being
        // unioned
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        DS ds = new DS(n);
        int connections = 0;
        for (int[] log : logs)
        {
            int time = log[0];
            int a = log[1];
            int b = log[2];
            
            if (ds.root(a) != ds.root(b))
            {
                ds.union(a, b);
                connections++;
                if (connections == n - 1)
                    return time;
            }
        }
        
        return -1;
    }
}

class DS
{
    int [] p;
    
    public DS (int n)
    {
        p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;
    }
    
    public void union(int a, int b)
    {
        int rootA = root(a);
        int rootB = root(b);
        p[rootA] = rootB; 
    }
    
    public int root(int a)
    {
        while (p[a] != a)
        {
            p[a] = p[p[a]];
            a = p[a];
        }
        
        return a;
    }
}