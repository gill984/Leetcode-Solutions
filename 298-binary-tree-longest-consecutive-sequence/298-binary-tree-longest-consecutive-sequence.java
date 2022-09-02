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
    public int longestConsecutive(TreeNode root)
    {
        if(root == null)
            return 0;
        // From test cases, seems like sequences only count in positive direction
        return dfs(root, 1);
    }
    
    public int dfs(TreeNode node, int length)
    {
        int res = length;
        if(node.right != null)
        {
            if(node.right.val == node.val + 1)
            {
                res = Math.max(res, dfs(node.right, length + 1));
            }
            else
            {
                res = Math.max(res, dfs(node.right, 1));
            }
        }
        
        if(node.left != null)
        {
            if(node.left.val == node.val + 1)
            {
                res = Math.max(res, dfs(node.left, length + 1));
            }
            else
            {
                res = Math.max(res, dfs(node.left, 1));
            }
        }
        
        //System.out.println(length);
        
        return res;
    }
}