class Solution {
    double max = 0.0;
    final int SUM = 0;
    final int COUNT = 1;
    
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public double[] dfs(TreeNode curNode)
    {
        if (curNode == null)
            return null;
        
        double [] leftVals = dfs(curNode.left);
        double [] rightVals = dfs(curNode.right);
        
        double count = 1.0;
        double sum = curNode.val;
        
        if (leftVals != null)
        {
            sum += leftVals[SUM];
            count += leftVals[COUNT];
        }
        
        if (rightVals != null)
        {
            sum += rightVals[SUM];
            count += rightVals[COUNT];
        }
        
        // sum / count is the average value of this subtree, check if it's best
        max = Math.max(sum / count, max);
        
        // return result up the tree
        double [] result = new double[2];
        result[SUM] = sum;
        result[COUNT] = count;
        return result;
    }
}