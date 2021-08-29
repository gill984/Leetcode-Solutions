/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        postOrderRecurse(root, result);
        return result;
    }
    
    public void postOrderRecurse(Node n, List<Integer> result) {
        // If n is null, just return without doing anything
        if (n == null)
            return;
        
        // Add all children values recursively
        if (n.children != null)
            for (Node child : n.children)
                postOrderRecurse(child, result);
        
        // All children values added, add this value
        result.add(n.val);
    }
}