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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete)
            toDelete.add(i);
        Set<TreeNode> roots = new HashSet<>();
        traverseAndDelete(root, toDelete, roots, true);
        return new ArrayList<TreeNode>(roots);
    }
    
    public boolean traverseAndDelete(TreeNode cur, Set<Integer> toDelete, Set<TreeNode> roots, boolean isRootNode)
    {
        if (cur == null)
            return false;
        
        boolean deleteMe = toDelete.contains(cur.val);
        if (!deleteMe && isRootNode)
            roots.add(cur);
        
        boolean deleteLeft = traverseAndDelete(cur.left, toDelete, roots, deleteMe);
        boolean deleteRight = traverseAndDelete(cur.right, toDelete, roots, deleteMe);
        
        if (deleteLeft)
            cur.left = null;
        if (deleteRight)
            cur.right = null;
        
        return deleteMe;        
    }
}