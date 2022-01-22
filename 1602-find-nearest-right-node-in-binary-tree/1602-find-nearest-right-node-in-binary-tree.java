class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null)
            return null;
        
        // Level order traversal and check for node u
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(new TreeNode(0));
        
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            
            if (node.val == 0)
            {
                if (!queue.isEmpty())
                {
                    queue.offer(new TreeNode(0));
                }
            }
            else
            {
                if (node.val == u.val)
                {
                    TreeNode next = queue.poll();
                    return next.val == 0 ? null : next;
                }
                    

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        
        return null;
    }
}