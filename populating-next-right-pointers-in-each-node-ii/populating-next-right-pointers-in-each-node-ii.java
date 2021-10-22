class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        
        // Do a level order traversal
        // While on each level, the next pointer is set to q.peek()
        Queue<Node> nextLevel = new ArrayDeque<>();
        nextLevel.offer(root);
        
        while (!nextLevel.isEmpty())
        {
            Queue<Node> level = nextLevel;
            nextLevel = new ArrayDeque<>();
            while (!level.isEmpty())
            {
                Node cur = level.poll();
                cur.next = level.isEmpty() ? null : level.peek();
                if (cur.left != null)
                    nextLevel.offer(cur.left);
                
                if (cur.right != null)
                    nextLevel.offer(cur.right);
            }
        }
        
        return root;
    }
}