class Solution {
    int preIdx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode traverse(int [] preorder, int [] inorder, int lo, int hi) {
        if (lo > hi)
            return null;
        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);
        int mid = 0;
        
        for (mid = lo; mid <= hi; mid++)
            if (inorder[mid] == val)
                break;
        
        root.left = traverse(preorder, inorder, lo, mid - 1);
        root.right = traverse(preorder, inorder, mid + 1, hi);
        return root;
    }
}