class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs (TreeNode curr, int depth) {
        return curr == null ? depth : Math.max(dfs(curr.left, depth + 1), dfs(curr.right, depth + 1));
    }
}