class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // Union the cycles and sort them
        int n = s.length();
        DS ds = new DS(n);
        for (List<Integer> pair : pairs)
            ds.union(pair.get(0), pair.get(1));
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int group = ds.root(i);
            map.putIfAbsent(group, new PriorityQueue<Character>());
            map.get(group).offer(s.charAt(i));
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(map.get(ds.root(i)).poll());
        
        return res.toString();
    }
}

class DS {
    int [] p;
    
    public DS (int size) {
        p = new int [size];
        for (int i = 0; i < size; i++)
            p[i] = i;
    }
    
    public void union (int a, int b) {
        p[root(a)] = root(b);
    }
    
    public int root (int a) {
        while (p[a] != a) {
            a = p[a];
            p[a] = p[p[a]];
        }
        return a;
    }
}