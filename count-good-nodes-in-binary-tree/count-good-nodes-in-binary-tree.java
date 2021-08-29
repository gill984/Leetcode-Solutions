class Solution {
    public int goodNodes(TreeNode root) {
        // Traverse tree using dfs and keep track of current max node in path
        // if current node >= max, good node increment good node count
        // and update max if node val > max, return 1 + child searches
        // else bad node return 0 + child searches
        return dfsGoodNodes(root, Integer.MIN_VALUE);
    }
    
    public int dfsGoodNodes(TreeNode cur, int curMax)
    {
        if (cur == null)
            return 0;
        
        curMax = Math.max(cur.val, curMax);
        int good = (cur.val == curMax) ? 1 : 0;
        return good + dfsGoodNodes(cur.left, curMax) + dfsGoodNodes(cur.right, curMax);
    }
}