class Solution
{
    public int maxAncestorDiff(TreeNode root)
    {
        // Postorder traversal where we return the minimum and maximum
        if (root == null)
            return 0;
        
        int [] res = postorder(root);
        return res[0];
    }
    
    public int[] postorder(TreeNode curr)
    {
        if (curr == null)
            return null;
        
        int [] left = postorder(curr.left);
        int [] right = postorder(curr.right);
        
        // v is 0 with 1 nodes, min is this val, max is also this val
        int [] res = new int [] {0, curr.val, curr.val};
        
        if (left != null)
        {
            res[0] = Math.max(res[0], left[0]);
            res[1] = Math.min(res[1], left[1]);
            res[2] = Math.max(res[2], left[2]);
        }
        if (right != null)
        {
            res[0] = Math.max(res[0], right[0]);
            res[1] = Math.min(res[1], right[1]);
            res[2] = Math.max(res[2], right[2]);
        }
        
        // Minimum and maximum are set
        // check if they can be used with this node to improve
        res[0] = Math.max(res[0], Math.max(Math.abs(curr.val - res[1]), Math.abs(curr.val - res[2])));
        
        return res;
    }
}