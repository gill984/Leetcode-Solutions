 class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode last = null;
    public void recoverTree(TreeNode root)
    {
        traverse(root);
        
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
     
    public void traverse(TreeNode cur)
    {
        if (cur == null)
            return;
        
        
        traverse(cur.left);
        if (prev != null && cur.val < prev.val)
        {
            if (first == null)
                first = prev;
            last = cur;
        }
        prev = cur;
        
        traverse(cur.right);
    }
}