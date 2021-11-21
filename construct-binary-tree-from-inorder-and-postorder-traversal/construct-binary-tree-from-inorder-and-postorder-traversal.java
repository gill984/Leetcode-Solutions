class Solution
{
    int poIndex;
    Map<Integer, Integer> valToIn;
        
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {        
        valToIn = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++)
        {
            valToIn.put(inorder[i], i);
        }
        
        poIndex = n - 1;
        TreeNode root = buildRecursive(inorder, 0, n - 1, postorder);
        return root;
    }
    
    public TreeNode buildRecursive(int[] inorder, int inLo, int inHi, int [] postorder)
    {
        if (poIndex < 0 || inLo > inHi)
            return null;
        
        // Last element in postorder is the current root element
        int val = postorder[poIndex--];
        TreeNode curr = new TreeNode(val);
        int inIndex = valToIn.get(val);
        
        // In the inorder array, left side of root is left subtree, right is right subtree
        curr.right = buildRecursive(inorder, inIndex + 1, inHi, postorder);
        curr.left = buildRecursive(inorder, inLo, inIndex - 1, postorder);
        
        return curr;
    }
}