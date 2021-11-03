class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        // There is only 1 path to each node
        res = 0;
        preorder(root, 0);
        return res;
    }
    
    public void preorder(TreeNode curr, int parentSum)
    {
        if (curr == null)
            return;
        
        int sum = curr.val + (10 * parentSum);
        preorder(curr.left, sum);
        preorder(curr.right, sum);
        if (curr.left == null && curr.right == null)
            res += sum;
    }
}