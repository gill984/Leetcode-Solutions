class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null)
            return null;
        
        // Level order traversal and check for node u
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            
            if (node == null)
            {
                if (!queue.isEmpty())
                {
                    queue.offer(null);
                }
            }
            else
            {
                if (node.val == u.val)
                {
                    return queue.poll();
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