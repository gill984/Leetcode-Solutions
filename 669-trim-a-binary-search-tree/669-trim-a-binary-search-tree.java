class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // When a node is removed, at least one of the child nodes and its
        // entire subtree will also need to be removed. Right at that
        // moment you can just move the other child into where this node was.
        if (root == null)
            return null;
        
        if (root.val < low)
        {
            // This node and entire left subtree should be removed
            root.left = null;
            return trimBST(root.right, low, high);
        }
        else if (root.val > high)
        {
            root.right = null;
            return trimBST(root.left, low, high);
        }
        else
        {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}