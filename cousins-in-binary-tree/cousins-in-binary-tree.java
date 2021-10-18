class Solution {
    int xDepth;
    int xParent;
    int yDepth;
    int yParent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, 0);
        System.out.println(xDepth);
        System.out.println(yDepth);
        return (xDepth == yDepth && xParent != yParent);
    }
    
    public void dfs(TreeNode cur, int x, int y, int parent, int depth)
    {
        if (cur == null)
            return;
        else if (cur.val == x)
        {
            xDepth = depth;
            xParent = parent;
        }
        else if (cur.val == y)
        {
            yDepth = depth;
            yParent = parent;
        }
        
        dfs(cur.left, x, y, cur.val, depth + 1);
        dfs(cur.right, x, y, cur.val, depth + 1);
    }
}