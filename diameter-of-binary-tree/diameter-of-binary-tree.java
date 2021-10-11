class Solution {
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        postOrderDistance(root);
        return res;
    }
    
    public int postOrderDistance(TreeNode cur)
    {
        if (cur == null)
            return 0;
        
        int leftDistance = postOrderDistance(cur.left);
        int rightDistance = postOrderDistance(cur.right);
        res = Math.max(leftDistance + rightDistance, res);
        return Math.max(leftDistance, rightDistance) + 1;
    }
}