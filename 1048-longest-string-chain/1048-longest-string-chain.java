class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int longestStrChain(String[] words) {
        // Build graph and find longest path in the graph
        int n = words.length;
        Node [] nodes = new Node[words.length];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(words[i], i);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) 
                    continue;
                if (isPredecessor(words[i], words[j]))
                    nodes[i].predOf.add(j);
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++)
                max = Math.max(max, dfs(nodes, i));
        
        return max;
    }
    
    public boolean isPredecessor (String s, String t) {
        if (s.length() != t.length() - 1)
            return false;
        
        boolean usedSkip = false;
        for (int i = 0, j = 0; i < s.length();) {
            if (s.charAt(i) != t.charAt(j)) {
                if (usedSkip)
                    return false;
                usedSkip = true;
                j++;
            } else {
                i++;
                j++;
            }
        }
        
        return true;
    }
    
    public int dfs (Node [] nodes, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        Node node = nodes[i];
        int max = 0;
        for (int pOf : node.predOf) {
            max = Math.max(max, dfs (nodes, pOf));
        }
        
        memo.put(i, max + 1);
        return max + 1;
    }
}

class Node {
    String s;
    int idx;
    List<Integer> predOf;
    
    public Node (String str, int i) {
        s = str;
        idx = i;
        predOf = new ArrayList<>();
    }
}