class Solution
{
    public int widthOfBinaryTree(TreeNode root)
    {
        int res = 0;
        
        if (root == null)
            return res;
        
        // Do a level order traversal and keep track of node numbers
        // left child is num * 2, right child is num * 2 + 1
        Queue<Pair> next = new ArrayDeque<>();
        next.offer(new Pair(root, 1));
        
        while (!next.isEmpty())
        {
            Queue<Pair> cur = next;
            next = new ArrayDeque<>();
            
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            
            while (!cur.isEmpty())
            {
                Pair p = cur.poll();
                max = Math.max(max, p.num);
                min = Math.min(min, p.num);
                
                if (p.node.left != null)
                    next.offer(new Pair(p.node.left, p.num * 2));
                
                if (p.node.right != null)
                    next.offer(new Pair(p.node.right, p.num * 2 + 1));
            }
            
            // System.out.println("Min: " + min + ", Max: " + max);
            
            
            res = Math.max(res, (int)(max - min + 1));
        }
        
        return res;
    }
    
    class Pair
    {
        TreeNode node;
        long num;
        
        public Pair(TreeNode n, long val)
        {
            node = n;
            num = val;
        }
    }
}