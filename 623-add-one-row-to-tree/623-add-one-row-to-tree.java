class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            root = newRoot;
        } else {
            dfs(root, val, depth);
        }
        return root;
    }
    
    public void dfs(TreeNode curr, int val, int depth) {
        if (curr == null)
            return;
        
        if (depth == 2) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = curr.left;
            newRight.right = curr.right;
            curr.left = newLeft;
            curr.right = newRight;
        } else {
            dfs(curr.left, val, depth - 1);
            dfs(curr.right, val, depth - 1);
        }
    }
}