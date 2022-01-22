class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null)
            return null;
        
        // Level order traversal and check for node u
        Queue<TreeNode> curr = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        next.offer(root);
        
        while (!next.isEmpty())
        {
            curr = next;
            next = new ArrayDeque<TreeNode>();
            
            while (!curr.isEmpty())
            {
                TreeNode node = curr.poll();
                
                // Found u, return next value in curr
                if (node.val == u.val)
                {
                    return (curr.isEmpty() ? null : curr.poll());
                }
                
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
            }
        }
        
        return null;
    }
}