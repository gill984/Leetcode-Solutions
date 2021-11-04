class Solution
{
    int res;
    public int sumOfLeftLeaves(TreeNode root)
    {
        res = 0;
        traverseSum(root, false);
        return res;
    }
    
    public void traverseSum(TreeNode curr, boolean isLeft)
    {
        if (curr == null)
            return;
        
        traverseSum(curr.left, true);
        traverseSum(curr.right, false);
        
        if (curr.left == null && curr.right == null && isLeft)
            res += curr.val;
    }
}