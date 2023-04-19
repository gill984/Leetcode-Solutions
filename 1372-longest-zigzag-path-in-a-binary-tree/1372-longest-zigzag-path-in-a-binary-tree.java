class Solution {
    int LEFT = 0;
    int RIGHT = 1;
    int res;
    
    public int longestZigZag(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
    
    public int[] dfs (TreeNode curr) {
        if (curr == null)
            return new int [] {-1, -1};
        
        int [] leftLength = dfs(curr.left);
        int [] rightLength = dfs(curr.right);
        int leftDistance = leftLength[RIGHT] + 1;
        int rightDistance = rightLength[LEFT] + 1;
        // System.out.println("Node " + curr.val + " leftDistance = " + leftDistance + ", rightDistance = " + rightDistance);
        
        res = Math.max(res, Math.max(leftDistance, rightDistance));
        return new int [] {leftDistance, rightDistance};
    }
}