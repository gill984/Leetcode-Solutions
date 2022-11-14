class Solution {    
    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(stones.length);
        Map<Integer, Integer> rowStone = new HashMap<>();
        Map<Integer, Integer> colStone = new HashMap<>();
        
        for (int id = 0; id < stones.length; id++) {
            int row = stones[id][0];
            int col = stones[id][1];
            
            if (rowStone.containsKey(row))
                ds.union(id, rowStone.get(row));
            else
                rowStone.put(row, id);
            
            if (colStone.containsKey(col))
                ds.union(id, colStone.get(col));
            else
                colStone.put(col, id);
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