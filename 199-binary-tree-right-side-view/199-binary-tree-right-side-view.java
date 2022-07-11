class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<int[]> depthToNode = new ArrayList<>();
        traverse(root, depthToNode, 0, 1);
        List<Integer> res = new ArrayList<>();
        for (int[] val : depthToNode)
            res.add(val[1]);
        return res;
    }
    
    public void traverse (TreeNode n, List<int[]> depthToNode, int depth, int x) {
        if (n == null)
            return;
        
        int [] pair = new int [] {x, n.val};
        if (depthToNode.size() <= depth)
            depthToNode.add(pair);
        else if (depthToNode.get(depth)[0] < x)
            depthToNode.set(depth, pair);
        
        traverse(n.left, depthToNode, depth + 1, x * 2);
        traverse(n.right, depthToNode, depth + 1, (x * 2) + 1);
    }
}