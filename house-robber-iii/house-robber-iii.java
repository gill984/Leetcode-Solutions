class Solution {
    public int rob(TreeNode root) {
        // postorder rob
        int [] res = postorder(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] postorder(TreeNode curr)
    {
        // Use return the maximum using this node as res[0]
        // and the maximum without using this node as res[1]
        if (curr == null)
            return new int [] {0, 0};
        
        int [] left = postorder(curr.left);
        int [] right = postorder(curr.right);
        
        return new int [] {curr.val + left[1] + right[1], Math.max(left[1], left[0]) + Math.max(right[0], right[1])};
    }
}