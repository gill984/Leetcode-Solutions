/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
    
    public Node dfs(Node curr, Map<Node, Node> oldToNew) {
        if (curr == null)
            return null;
        
        if (oldToNew.containsKey(curr)) {
            return oldToNew.get(curr);
        }
        
        Node newNode = new Node(curr.val, new ArrayList<>());
        oldToNew.put(curr, newNode);
        for (Node nbr : curr.neighbors) {
            newNode.neighbors.add(dfs(nbr, oldToNew));
        }
        return newNode;
    }
}