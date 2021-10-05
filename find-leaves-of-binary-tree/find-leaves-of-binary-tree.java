class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // Calculate distance to bottom for each node
        // Distance to bottom is 1 more than the max of left and right child distance to bottom
        List<List<Integer>> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    
    public int postorder(TreeNode cur, List<List<Integer>> res)
    {
        if (cur == null)
            return 0;
        
        int leftDistance = postorder(cur.left, res);
        int rightDistance = postorder(cur.right, res);
        
        int distance = Math.max(leftDistance, rightDistance) + 1;
        if (res.size() < distance)
            res.add(new ArrayList<Integer>());
        res.get(distance - 1).add(cur.val);
        return distance;
    }
}