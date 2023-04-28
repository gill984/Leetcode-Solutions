class Solution {
    public int numSimilarGroups(String[] strs) {
        DisjointSet ds = new DisjointSet(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (areSimilarStrings(strs[i], strs[j]))
                    ds.union(i, j);
            }
        }
        return ds.numGroups;
    }
    
    public boolean areSimilarStrings(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        return diff <= 2;
    }
}

class DisjointSet {
    int [] p;
    int numGroups;
    
    public DisjointSet (int size) {
        p = new int [size];
        for (int i = 0; i < size; i++)
            p[i] = i;
        numGroups = size;
    }
    
    public void union (int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        
        if (rootA == rootB)
            return;
        
        p[findRoot(a)] = p[findRoot(b)];
        numGroups--;
    }
    
    public int findRoot (int a) {
        while (p[a] != a) {
            p[a] = p[p[a]];
            a = p[a];
        }
        
        return a;
    }
}