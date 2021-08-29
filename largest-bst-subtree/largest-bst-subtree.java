class Solution {
    final int MAX = 0;
    final int MIN = 1;
    final int COUNT = 2;
    final int IS_BST = 3;
    int maxCount = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        // dfs through tree, return value is whether this subtree is a BST
        // as well as the number of nodes
        // return (maximum node val, minimum node val, count, isBST)
        if (root != null)
            dfs(root);
        return maxCount;
    }
    
    public int [] dfs(TreeNode cur)
    {
        // cur is a leaf node
        if (cur.left == null && cur.right == null)
        {
            maxCount = Math.max(maxCount, 1);
            return new int [] {cur.val, cur.val, 1, 1};
        }
        
        int [] leftResults = (cur.left == null) ? null : dfs(cur.left);
        int [] rightResults = (cur.right == null) ? null : dfs(cur.right);
        int count = 1;
        int max = cur.val;
        int min = cur.val;
        int isBst = 1;
        
        if (leftResults != null)
        {
            if (leftResults[MAX] >= cur.val || leftResults[IS_BST] == 0)
                isBst = 0;
            else
                count += leftResults[COUNT];
            min = leftResults[MIN];
        }
        
        if (isBst == 1 && rightResults != null)
        {
            if (rightResults[MIN] <= cur.val || rightResults[IS_BST] == 0)
                isBst = 0;
            else
                count += rightResults[COUNT];
            max = rightResults[MAX];
        }
        
        if (isBst == 1)
        {
            maxCount = Math.max(maxCount, count);
        }
        
        return new int [] {max, min, count, isBst};
    }
}