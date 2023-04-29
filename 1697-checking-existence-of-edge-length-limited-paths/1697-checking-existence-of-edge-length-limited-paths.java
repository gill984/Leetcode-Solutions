class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int q = queries.length;
        int [][] queriesWithIndex = new int [q][4];
        for (int i = 0; i < q; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        int edgeIdx = 0;
        boolean [] res = new boolean [q];
        DisjointSet ds = new DisjointSet(n);
        
        for (int [] query : queriesWithIndex) {
            int fromNode = query[0];
            int toNode = query[1];
            int limit = query[2];
            int originalIndex = query[3];
            
            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                ds.union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }
            
            res[originalIndex] = (ds.findRoot(fromNode) == ds.findRoot(toNode));
        }
        
        return res;
    }
}

class DisjointSet {
    int [] p;
    
    public DisjointSet(int size) {
        p = new int [size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
    }
    
    public void union (int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        
        p[rootA] = rootB;
    }
    
    public int findRoot(int a) {
        while (a != p[a]) {
            p[a] = p[p[a]];
            a = p[a];
        }
        return a;
    }
}