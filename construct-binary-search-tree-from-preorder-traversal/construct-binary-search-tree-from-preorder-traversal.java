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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        traverse(root, preorder, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    public int traverse(TreeNode cur, int[] preorder, int index, int min, int max)
    {
        if (index >= preorder.length)
            return index;
        
        int val = preorder[index];
        if (val < cur.val && val >= min)
        {
            TreeNode left = new TreeNode(val);
            cur.left = left;
            index = traverse(cur.left, preorder, index + 1, min, cur.val - 1);
        }
        
        if (index >= preorder.length)
            return index;
        val = preorder[index];
        if (val > cur.val && val <= max)
        {
            TreeNode right = new TreeNode(val);
            cur.right = right;
            index = traverse(cur.right, preorder, index + 1, cur.val + 1, max);
        }
        
        return index;
    }
}