/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    HashSet<TreeNode> visited = new HashSet<TreeNode>();
    
    public int longestConsecutive(TreeNode root)
    {
        if(root == null)
            return 0;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        int max = 1;
        
        while(!q.isEmpty())
        {
            // Pull off node in order to start initial search
            TreeNode n = q.poll();
            
            // Perform search on this node.
            max = Math.max(max, search(n, 0, 1) + search(n, 0, -1) + 1);
            
            if(n.left != null)
            {
                q.offer(n.left);
            }
            if(n.right != null)
            {
                q.offer(n.right);
            }
        }
        
        return max;
    }
    
    public int search(TreeNode n, int length, int dir)
    {
        int res = length;
        if(n.left != null)
        {
            if(n.left.val == n.val + dir)
            {
                res = Math.max(res, search(n.left, length + 1, dir));
            }
        }
        
        if(n.right != null)
        {
            if(n.right.val == n.val + dir)
            {
                res = Math.max(res, search(n.right, length + 1, dir));
            }
        }
        
        return res;
    }
}