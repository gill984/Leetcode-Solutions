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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        // Reverse inorder traversal
        // Store running sum
        convertBST(root.right);
        
        int temp = root.val;
        root.val += sum;
        sum += temp;
        
        convertBST(root.left);
        
        return root;
    }
}