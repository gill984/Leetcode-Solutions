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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> next = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        next.addLast(root);
        for (int i = 0; !next.isEmpty(); i++) {
            Deque<TreeNode> current = new ArrayDeque<>(next);
            next = new ArrayDeque<>();
            res.add(new ArrayList<>());
            while (!current.isEmpty()) {
                TreeNode t = current.removeFirst();
                res.get(i).add(t.val);
                
                if (t.left != null)
                    next.addLast(t.left);
                
                if (t.right != null)
                    next.addLast(t.right);
            }
        }
        
        return res;
    }
}