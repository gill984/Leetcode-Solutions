class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        DisjointSet ds = new DisjointSet(n);
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (isConnected[i][j] == 1)
                    ds.union(i, j);
        
        return ds.countComponents;
    }
    
    class DisjointSet {
        int [] p;
        int countComponents;
        
        public DisjointSet(int size) {
            p = new int [size];
            for (int i = 0; i < size; i++)
                p[i] = i;
            countComponents = size;
        }
        
        public int findRoot(int a) {
            while (a != p[a]) {
                p[a] = p[p[a]];
                a = p[a];
            }
            return a;
        }
        
        public void union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB)
                countComponents--;
            p[rootA] = rootB;
        }
    }
}