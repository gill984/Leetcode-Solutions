class Solution {
    int tilt;
    
    public int findTilt(TreeNode root) {
        tilt = 0;
        traverseSum(root);
        return tilt;
    }
    
    public int traverseSum(TreeNode curr)
    {
        if (curr == null)
            return 0;
        
        int left = traverseSum(curr.left);
        int right = traverseSum(curr.right);
        tilt += Math.abs(left - right);
        
        return left + right + curr.val;
    }
}