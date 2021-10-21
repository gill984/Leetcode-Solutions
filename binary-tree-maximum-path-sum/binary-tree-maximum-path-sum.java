
class Solution {
    int max;
    public int maxPathSum(TreeNode root)
    {
        if (root == null)
            return 0;

        max = root.val;
        postorder(root);
        return max;
    }

    public int postorder(TreeNode root)
    {
        if (root == null)
            return 0;

        int leftPathSum = Math.max(postorder(root.left), 0);
        int rightPathSum = Math.max(postorder(root.right), 0);
        max = Math.max(max, root.val + leftPathSum + rightPathSum);

        return Math.max(leftPathSum + root.val, rightPathSum + root.val);
    }

}