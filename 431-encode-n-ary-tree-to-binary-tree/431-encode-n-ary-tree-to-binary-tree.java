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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Right edge means it's also in that group of children
// Left edge means this is a child of the parent node along with every direct right edge from this node


class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null)
            return null;
        
        TreeNode binary = new TreeNode(root.val);
        encodeToBinary(binary, root);
        return binary;
    }
    
    private void encodeToBinary(TreeNode binary, Node root)
    {
        if (root == null || root.children == null)
            return;
        
        TreeNode prev = null;
        for (Node child : root.children)
        {
            TreeNode binaryChild = new TreeNode(child.val);
            encodeToBinary(binaryChild, child);
            if (prev == null)
                binary.left = binaryChild;
            else
                prev.right = binaryChild;
            
            prev = binaryChild;
        }
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null)
            return null;
        
        Node n = new Node(root.val, new ArrayList<>());
        decodeToNary(root, n);
        return n;
    }
    
    private void decodeToNary(TreeNode root, Node n)
    {
        if (root == null)
            return;
        
        TreeNode bChild = root.left;
        
        while (bChild != null)
        {
            Node nChild = new Node(bChild.val, new ArrayList<>());
            decodeToNary(bChild, nChild);
            n.children.add(nChild);
            bChild = bChild.right;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));













