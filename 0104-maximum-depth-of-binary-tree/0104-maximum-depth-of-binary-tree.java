class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs (TreeNode curr, int depth) {
        if (curr == null)
            return depth;
        return Math.max(dfs(curr.left, depth + 1), dfs(curr.right, depth + 1));
    }
}