class BSTIterator {
    Deque<TreeNode> next;
    Deque<TreeNode> prev;
    Set<TreeNode> added;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        next = new ArrayDeque<>();
        prev = new ArrayDeque<>();
        added = new HashSet<>();
        curr = null;
        
        while (root != null)
        {
            next.addLast(root);
            added.add(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !next.isEmpty();
    }
    
    public int next() {
        if (curr != null)
            prev.addLast(curr);
        
        curr = next.removeLast();
        TreeNode n = curr.right;
        while (n != null && !added.contains(n))
        {
            next.addLast(n);
            added.add(n);
            n = n.left;
        }
        
        return curr.val;
    }
    
    public boolean hasPrev() {
        return !prev.isEmpty();
    }
    
    public int prev() {
        if (curr != null)
            next.addLast(curr);
        
        curr = prev.removeLast();
        return curr.val;
    }
}