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
class Solution
{
    final int LEFT = 0;
    final int RIGHT = 1;
    
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if (root == null)
            return root;
        
        TreeNode gp = new TreeNode();
        removeRecursive(root, gp, LEFT, key);        
        
        // Only rough case is deleting the root
        if (root.val != key)
            return root;
        else
            return gp.left;
    }
    
    public TreeNode rightMost(TreeNode curr)
    {
        if (curr.right != null)
            return rightMost(curr.right);
        else
            return curr;
    }
    
    public void removeRecursive(TreeNode curr, TreeNode parent, int dir, int key)
    {
        if (curr == null)
            return;
        
        if (curr.val == key)
        {
            if (curr.left == null && curr.right == null)
            {
                if (dir == LEFT)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else if (curr.left == null)
            {
                if (dir == LEFT)
                    parent.left = curr.right;
                else
                    parent.right = curr.right;
            }
            else if (curr.right == null)
            {
                if (dir == LEFT)
                    parent.left = curr.left;
                else
                    parent.right = curr.left;
            }
            else
            {
                if (dir == LEFT)
                    parent.left = curr.left;
                else
                    parent.right = curr.left;
                
                TreeNode br = rightMost(curr.left);
                br.right = curr.right;
            }
        }
        else
        {
            removeRecursive(curr.left, curr, LEFT, key);
            removeRecursive(curr.right, curr, RIGHT, key);
        }
    }
}