class Solution {
    double max = 0.0;
    final int SUM = 0;
    final int COUNT = 1;
    
    public double maximumAverageSubtree(TreeNode root) {
        if (root != null)
            dfs(root);
        return max;
    }
    
    public int[] dfs(TreeNode curNode)
    {
        if (curNode == null)
            return new int [] {0, 0};
        
        int [] leftVals = dfs(curNode.left);
        int [] rightVals = dfs(curNode.right);
        int sum = leftVals[SUM] + rightVals[SUM] + curNode.val;
        int count = leftVals[COUNT] + rightVals[COUNT] + 1;
        
        max = Math.max( (double) sum / (double) count, max);
        
        // return result up the tree
        int [] result = new int[2];
        result[SUM] = sum;
        result[COUNT] = count;
        return result;
    }
}