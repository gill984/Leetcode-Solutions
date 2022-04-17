class Solution {
    TreeNode res = null;
    TreeNode prev = null;
    
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        
        increasingBST(root.left);
        if (prev != null)
            prev.right = root;
        prev = root;
        
        if (res == null)
            res = root;
        
        root.left = null;
        increasingBST(root.right);
        return res;
    }
}