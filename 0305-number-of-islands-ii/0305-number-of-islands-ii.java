class Solution
{
    public List<Integer> numIslands2(int m, int n, int[][] positions)
    {
        if(positions == null || m == 0 || n == 0)
            return null;
        
        List<Integer> list = new ArrayList<Integer>();    
        DisjointSet ds = new DisjointSet(m * n);
        int count = 0;
        
        for(int i = 0; i < positions.length; i++)
        {
            int row = positions[i][0];
            int col = positions[i][1];
            int key = row * n + col;
            
            int [] rowPos = new int [] {0, 0, -1, 1};
            int [] colPos = new int [] {-1, 1, 0, 0};
            ArrayList<Integer> nbrs = new ArrayList<Integer>();
            
            for(int j = 0; j < 4; j++)
            {
                int nbrRow = row + rowPos[j];
                int nbrCol = col + colPos[j];
                
                if(nbrRow >= 0 && nbrRow < m && nbrCol >= 0 && nbrCol < n)
                {
                    nbrs.add(nbrRow * n + nbrCol);
                }
            }
            count += ds.insert(key, nbrs);
            list.add(count);
        }
        
        return list;
    }
}

class DisjointSet
{
    public int [] parent;
    public int [] size;
    
    public DisjointSet(int x)
    {
        this.parent = new int [x];
        this.size = new int [x];
        
        // Initalize disjoint set
        for(int i = 0; i < parent.length; i++)
            parent[i] = -1;
    }
    
    public int insert(int x, ArrayList<Integer> neighbors)
    {
        if(parent[x] != -1)
            return 0;
        
        parent[x] = x;
        size[x] = 1;
        int count = 1;
        
        for(int n : neighbors)
        {
            boolean joined = union(x, n);
            if(joined)
                --count;
        }
        
        return count;
    }
    
    public boolean union(int a, int b)
    {
        if(parent[a] == -1 || parent[b] == -1 || inSameSet(a, b))
            return false;
        
        int rootA = root(a);
        int rootB = root(b);
        
        if(size[rootA] < size[rootB])
        {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        else
        {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        
        return true;
    }
    
    public int root(int a)
    {
        while(parent[a] != a)
        {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        
        return a;
    }
    
    public boolean inSameSet(int a, int b)
    {
        return root(a) == root(b);
    }
}