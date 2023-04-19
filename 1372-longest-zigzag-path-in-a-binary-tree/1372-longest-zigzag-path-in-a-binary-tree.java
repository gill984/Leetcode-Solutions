class Solution {
    int LEFT = 0;
    int RIGHT = 1;
    int res = 0;
    
    public int longestZigZag(TreeNode root) {
        // Starting direction doesn't matter because this return val doesn't matter
        dfs(root, 0);
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