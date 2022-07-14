class Solution {
    int preIdx = 0;
    Map<Integer, Integer> inIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inIndex.put(inorder[i], i);
        
        return traverse(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode traverse(int [] preorder, int [] inorder, int lo, int hi) {
        if (lo > hi)
            return null;
        
        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);
        
        int mid = inIndex.get(val);
        
        root.left = traverse(preorder, inorder, lo, mid - 1);
        root.right = traverse(preorder, inorder, mid + 1, hi);
        return root;
    }
}