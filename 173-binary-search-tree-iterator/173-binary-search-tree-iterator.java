/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> inorderStack;
    
    public BSTIterator(TreeNode root) {
        inorderStack = new Stack<TreeNode>();
        inorder(root);
    }
    
    private void inorder(TreeNode n)
    {
        while (n != null)
        {
            inorderStack.push(n);
            n = n.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode n = inorderStack.pop();
        int result = n.val;
        inorder(n.right);
        return result;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inorderStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */