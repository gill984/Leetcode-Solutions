class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        if(root == null || root.left == null && root.right == null)
            return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max)
    {
        if(root == null)
            return true;
        
        if(root.val < max && root.val > min)
        {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max); 
        }
        else
        {
            return false;
        }
    }
}