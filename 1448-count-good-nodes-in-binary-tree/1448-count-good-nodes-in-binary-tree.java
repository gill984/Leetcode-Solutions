class Solution {
    int maxVal = Integer.MIN_VALUE;
    public int goodNodes(TreeNode curr) {
        if (curr == null)
            return 0;
        int temp = maxVal;
        maxVal = Math.max(curr.val, maxVal);
        int res = (curr.val >= maxVal ? 1 : 0) + goodNodes(curr.left) + goodNodes(curr.right);
        maxVal = temp;
        return res;
    }
}