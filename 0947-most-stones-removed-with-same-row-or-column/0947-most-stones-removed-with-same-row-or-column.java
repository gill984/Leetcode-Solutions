class Solution {    
    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(stones.length + 1);
        int[] rowStone = new int[10000];
        int[] colStone = new int[10000];
        
        for (int id = 0; id < stones.length; id++) {
            int row = stones[id][0];
            int col = stones[id][1];
            
            if (rowStone[row] != 0)
                ds.union(id + 1, rowStone[row]);
            else
                rowStone[row] = id + 1;
            
            if (colStone[col] != 0)
                ds.union(id + 1, colStone[col]);
            else
                colStone[col] = id + 1;
        }
        
        return ds.numConnections;
    }
    
    class DisjointSet {
        int [] p;
        int numConnections;
        
        public DisjointSet(int size) {
            numConnections = 0;
            p = new int [size];
            for (int i = 0; i < p.length; i++)
                p[i] = i;
        }
        
        public void union(int a, int b) {
            if (root(a) == root(b))
                return;
            
            numConnections++;
            p[root(a)] = p[root(b)];
        }
        
        public int root(int a) {
            while (a != p[a])
                a = p[a] = p[p[a]];
            
            return a;
        }
    }
}