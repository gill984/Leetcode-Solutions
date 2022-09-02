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
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> next = new ArrayList<TreeNode>();
        next.add(root);
        List<Double> res = new ArrayList<>();
        
        while (!next.isEmpty()) {
            List<TreeNode> curr = next;
            next = new ArrayList<>();
            double levelVal = 0.0;
            int denom = 0;
            for (TreeNode n : curr) {
                if (n.left != null)
                    next.add(n.left);
                if (n.right != null)
                    next.add(n.right);
                levelVal += n.val;
                denom++;
            }
            
            res.add(levelVal / denom);
        }
        
        return res;
    }
}