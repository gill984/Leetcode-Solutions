class Solution {
    public boolean equationsPossible(String[] equations) {
        List<String> notEquals = new ArrayList<>();
        DisjointSet ds = new DisjointSet();
        
        for (String equation : equations) {
            if (equation.contains("!"))
                notEquals.add(equation);
            else
                ds.union(equation.charAt(0), equation.charAt(3));
        }
        
        for (String equation : notEquals)
            if (ds.find(equation.charAt(0)) == ds.find(equation.charAt(3)))
                return false;
        
        return true;
    }
}

class DisjointSet {
    int [] p;
    int size = 26;
    
    public DisjointSet () {
        p = new int [size];
        for (int i = 0; i < size; i++)
            p[i] = i;
    }
    
    public int find(char c) {
        int a = c - 'a';
        while (a != p[a])
            a = p[a];
        
        return a;
    }
    
    public void union(char c1, char c2) {
        int a = find(c1);
        int b = find(c2);
        p[a] = b;
    }
}