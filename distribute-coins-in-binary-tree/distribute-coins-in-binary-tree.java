class Solution {
    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode cur)
    {
        if (cur == null)
            return 0;
        
        int lMoves = dfs(cur.left);
        int rMoves = dfs(cur.right);
        res += Math.abs(lMoves) + Math.abs(rMoves);
        return cur.val - 1 + lMoves + rMoves;
    }
}