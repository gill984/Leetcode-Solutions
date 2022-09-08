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
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        iterTraverse(root);
        return res;
    }
    
    public void traverse(TreeNode n)
    {
        if(n == null) return;
        
        traverse(n.left);
        res.add(n.val);
        traverse(n.right);
    }
    
    public void iterTraverse(TreeNode root)
    {
        if(root == null) return;
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode n = stack.pop();
            if(n == null)
                continue;
            if(n.left != null && !visited.contains(n.left))
            {
                stack.push(n);
                stack.push(n.left);
                continue;
            }
            res.add(n.val);
            visited.add(n);
            if(n.right != null)
                stack.push(n.right);
        }
    }
}