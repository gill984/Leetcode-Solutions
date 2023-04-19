class Solution {
    int LEFT = 0;
    int RIGHT = 1;
    int res = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, LEFT);
        return res;
    }
    
    public int dfs (TreeNode curr, int dir) {
        if (curr == null)
            return -1;
        
        int leftLength = dfs(curr.left, RIGHT) + 1;
        int rightLength = dfs(curr.right, LEFT) + 1;
        res = Math.max(res, Math.max(leftLength, rightLength));
        return (dir == RIGHT ? rightLength : leftLength);
    }
}