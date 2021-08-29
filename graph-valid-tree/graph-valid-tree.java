class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Best definition of a tree to remember for this problem is: A tree
        // is a connected graph where |nodes| - |edges| == 1.
        // Use check if nodes - edges == 1 then use union find to check if
        // there is only 1 connected component.
        if (n == 0)
            return true;
        else if (n - 1 != edges.length)
            return false;
        
        DJS uf = new DJS(n);
        for (int i = 0; i < edges.length; i++)
            uf.union(edges[i][0], edges[i][1]);
        
        int comp = uf.find(0);
        for (int i = 1; i < n; i++)
            if (uf.find(i) != comp)
                return false;
        
        return true;
    }
}

class DJS
{
    int parent [];
    public DJS(int n)
    {
        parent = new int [n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    public void union(int a, int b)
    {
        while (parent[a] != a)
        {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        while (parent[b] != b)
        {
            parent[b] = parent[parent[b]];
            b = parent[b];
        }
        parent[a] = b;
    }
    
    public int find(int a)
    {
        while (parent[a] != a)
        {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }
}