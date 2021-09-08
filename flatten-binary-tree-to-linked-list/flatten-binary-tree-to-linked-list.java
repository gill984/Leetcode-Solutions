class Solution {
    public void flatten(TreeNode root) {
        preorder(root);
    }
    
    // return bottom most node?
    public TreeNode preorder(TreeNode current)
    {
        if (current == null)
            return null;
     
        // Store off right because we're about to overwrite it
        TreeNode right = current.right;
        TreeNode left = current.left;
        
        if (right == null && left == null)
        {
            return current;
        }
        else if (right == null)
        {
            current.right = current.left;
            current.left = null;
            return preorder(current.right);
        }
        else if (left == null)
        {
            return preorder(current.right);
        }
        else
        {
            TreeNode bottomLeft = preorder(current.left);
            bottomLeft.right = current.right;
            current.right = current.left;
            current.left = null;
            return preorder(bottomLeft.right);
        }
    }
}