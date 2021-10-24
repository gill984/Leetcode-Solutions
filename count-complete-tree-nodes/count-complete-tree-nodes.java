class Solution {
    public int countNodes(TreeNode root) {
        int lo = findMin(root);
        int d = 32 - Integer.numberOfLeadingZeros(lo);
        int hi = (2 * lo);
        int res = lo;
        
        while (lo < hi)
        {
            int mid = (hi - lo) / 2 + lo;
            if (nodeExists(root, mid, d))
            {
                res = mid;
                lo = mid + 1;
            }
            else
                hi = mid;
        }
        
        return res;
    }
    
    public int findMin(TreeNode cur)
    {
        if (cur == null)
            return 0;
        else if (cur.left == null)
            return 1;
        else
            return 2 * findMin(cur.left);
    }
    
    public boolean nodeExists(TreeNode root, int label, int d)
    {
        TreeNode cur = root;
        int shift = d - 2;
        int mask = (1 << (shift));
        while (shift >= 0 && cur != null)
        {
            if ((label & mask) != 0)
                cur = cur.right;
            else
                cur = cur.left;
            shift -= 1;
            mask = (1 << (shift));
        }
        
        return (cur != null);
    }
}