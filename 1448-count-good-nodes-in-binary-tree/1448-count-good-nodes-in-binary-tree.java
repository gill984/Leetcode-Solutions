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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    public int dfs(TreeNode curr, int maxVal) {
        return curr == null ? 0 : (curr.val >= maxVal ? 1 : 0) + dfs(curr.left, Math.max(maxVal, curr.val)) + dfs(curr.right, Math.max(maxVal, curr.val));
    }
}