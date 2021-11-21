class Solution
{
    int poIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        // last element in postorder is the root
        // In the inorder array, left side of root is left subtree, right is right subtree
        int n = inorder.length;
        poIndex = n - 1;
        TreeNode root = buildRecursive(inorder, 0, n - 1, postorder);
        return root;
    }
    
    public TreeNode buildRecursive(int[] inorder, int inLo, int inHi, int [] postorder)
    {
        if (poIndex < 0 || inLo > inHi)
            return null;
        
        TreeNode curr = new TreeNode(postorder[poIndex]);
        poIndex--;
        
        int curIndex = 0;
        for (int i = inLo; i <= inHi; i++)
        {
            if (inorder[i] == curr.val)
            {
                curIndex = i;
                break;
            }
        }
        
        // Only try the right if we have a right subtree
        curr.right = buildRecursive(inorder, curIndex + 1, inHi, postorder);
        
        // Only try the left if we have a left subtree
        curr.left = buildRecursive(inorder, inLo, curIndex - 1, postorder);
        
        return curr;
    }
}