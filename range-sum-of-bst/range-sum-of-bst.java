class Solution
{
    public int rangeSumBST(TreeNode curr, int low, int high)
    {
        // nodes are unique in value
        // inclusive range low to high
        // Are low and high definitely in the tree? NO
        int sum = 0;
        
        if (curr == null)
            return sum;
        
        if (curr.val >= low && curr.val <= high)
            sum += curr.val;
        
        if (curr.val < high)
            sum += rangeSumBST(curr.right, low, high);
        if (curr.val > low)
            sum += rangeSumBST(curr.left, low, high);
        
        return sum;
    }
}