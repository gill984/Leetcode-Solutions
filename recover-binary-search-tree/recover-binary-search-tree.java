 class Solution {
    public void recoverTree(TreeNode root)
    {
        List<TreeNode> inorderList = new ArrayList<>();
        traverse(inorderList, root);
        
        // for (TreeNode n : inorderList)
        //     System.out.println(n.val);
        
        TreeNode leftSwap = null;
        TreeNode rightSwap = null;
        for (int i = 0; i + 1 < inorderList.size(); i++)
        {
            if (inorderList.get(i).val > inorderList.get(i + 1).val)
            {
                leftSwap = inorderList.get(i);
                break;
            }
        }
        
        for (int i = inorderList.size() - 1; i - 1 >= 0; i--)
        {
            if (inorderList.get(i).val < inorderList.get(i - 1).val)
            {
                rightSwap = inorderList.get(i);
                break;
            }
        }
        
        int temp = leftSwap.val;
        leftSwap.val = rightSwap.val;
        rightSwap.val = temp;
    }
     
    public void traverse(List<TreeNode> l, TreeNode cur)
    {
        if (cur == null)
            return;
        traverse(l, cur.left);
        l.add(cur);
        //System.out.println(cur.val);
        traverse(l, cur.right);
    }
}