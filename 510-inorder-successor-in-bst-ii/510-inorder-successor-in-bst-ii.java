class Solution {
    public Node inorderSuccessor(Node node) {
        // 3 cases
        // Either the node has a right node or it doesn't
        // If it has a right child we want the the leftmost node in the right subtree
        // Else keep going up the parent path until the node you come from is a left child, return that parent
        if (node.right == null)
            return parentTrail(node.parent, node);
        else
            return leftMost(node.right);
    }
    
    public Node parentTrail(Node parent, Node child) {
        if (parent == null || parent.left == child)
            return parent;
        else
            return parentTrail(parent.parent, parent);
    }
    
    public Node leftMost(Node n) {
        if (n.left == null)
            return n;
        else
            return leftMost(n.left);
    }
}