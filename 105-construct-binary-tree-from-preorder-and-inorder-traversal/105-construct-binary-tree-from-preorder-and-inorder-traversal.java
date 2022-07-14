class Solution {
    int preIdx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traverse(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode traverse(int [] preorder, int [] inorder, int loInorder, int hiInorder) {
        if (loInorder > hiInorder)
            return null;
        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);
        int midInorder = 0;
        
        for (midInorder = loInorder; midInorder <= hiInorder; midInorder++) {
            if (inorder[midInorder] == val)
                break;
        }
        
        root.left = traverse(preorder, inorder, loInorder, midInorder - 1);
        root.right = traverse(preorder, inorder, midInorder + 1, hiInorder);
        return root;
    }
}