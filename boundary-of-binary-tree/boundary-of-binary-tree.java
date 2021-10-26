class Solution
{
    public List<Integer> boundaryOfBinaryTree(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        addLeftBoundary(root.left, res);
        if (root.left != null || root.right != null)
            addLeaves(root, res);
        addRightBoundary(root.right, res);
        return res;        
    }
    
    public void addLeftBoundary(TreeNode cur, List<Integer> res)
    {
        if (cur == null)
            return;
        
        if (cur.left != null || cur.right != null)
            res.add(cur.val);
        else
            return;

        if (cur.left != null)
            addLeftBoundary(cur.left, res);
        else if (cur.right != null)
            addLeftBoundary(cur.right, res);
    }
    
    public void addLeaves(TreeNode cur, List<Integer> res)
    {
        if (cur == null)
            return;
        
        addLeaves(cur.left, res);
        if (cur.left == null && cur.right == null)
            res.add(cur.val);
        addLeaves(cur.right, res);
    }
    
    public void addRightBoundary(TreeNode cur, List<Integer> res)
    {
        if (cur == null)
            return;
        
        if (cur.left == null && cur.right == null)
            return;
        
        if (cur.right != null)
            addRightBoundary(cur.right, res);
        else if (cur.left != null)
            addRightBoundary(cur.left, res);
        
        res.add(cur.val);
    }
}