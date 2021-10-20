class Solution {
    public int removeStones(int[][] stones) {
        // any stones in the same row and column can be unioned to the same set
        DS disjointSet = new DS(20000);
        for(int i = 0; i < stones.length; i++)
        {
            disjointSet.union(stones[i][0], stones[i][1] + 10000);
        }
        
        Set<Integer> components = new HashSet<Integer>();
        for(int i = 0; i < stones.length; i++)
            components.add(disjointSet.find(stones[i][1] + 10000));
        
        return stones.length - components.size();
    }
}

class DS
{
    int [] p;
    public DS(int size)
    {
        p = new int[size];
        for(int i = 0; i < p.length; i++)
            p[i] = i;
    }
    
    public void union(int u, int v)
    {
        p[find(u)] = find(v);
    }
    
    public int find(int u)
    {
        while(p[u] != u)
        {
            p[u] = p[p[u]];
            u = p[u];
        }
        
        return u;
    }
}