class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }
    
    public void traverse (TreeNode n, List<Integer> depthToNode, int depth) {
        if (n == null)
            return;
        
        if (depthToNode.size() <= depth)
            depthToNode.add(n.val);
        else
            depthToNode.set(depth, n.val);
        
        traverse(n.left, depthToNode, depth + 1);
        traverse(n.right, depthToNode, depth + 1);
    }
}