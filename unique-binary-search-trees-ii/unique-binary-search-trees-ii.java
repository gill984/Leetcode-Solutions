class Solution {
    public List<TreeNode> generateTrees(int n) {
        TreeNode root = new TreeNode(1);
        List<TreeNode> result = new ArrayList<TreeNode>();
        result.add(root);
        for (int i = 2; i <= n; i++)
        {
            List<TreeNode> next = new ArrayList<TreeNode>();
            for (TreeNode t : result)
            {
                List<TreeNode> tList = addNode(i, t);
                next.addAll(tList);
            }
            result = next;
        }
        
        return result;
    }
    
    public List<TreeNode> addNode(int n, TreeNode root)
    {
        List<TreeNode> res = new ArrayList<TreeNode>();
        List<Integer> insertions = new ArrayList<Integer>();
        
        // Add this new node as root
        insertions.add(0);
        
        // Find other necessary insertions
        findInsertions(root, n, insertions);
        
        for (int i = 0; i < insertions.size(); i++)
        {
            int parent = insertions.get(i);
            TreeNode copy = new TreeNode();
            copyTree(root, copy);
            if (parent == 0)
            {
                TreeNode newRoot = new TreeNode(n);
                newRoot.left = copy;
                res.add(newRoot);
            }
            else
            {
                insertNode(copy, parent, n);
                res.add(copy);
            }
        }
        
        return res;
    }
    
    public void insertNode(TreeNode curNode, int parent, int n)
    {        
        if (curNode.val == parent)
        {
            TreeNode newNode = new TreeNode(n);
            TreeNode temp = curNode.right;
            curNode.right = newNode;
            newNode.left = temp;
        }
        else
        {
            insertNode(curNode.right, parent, n);
        }
    }
    
    public void findInsertions(TreeNode curNode, int n, List<Integer> insertions)
    {        
        insertions.add(curNode.val);
        if (curNode.right != null)
            findInsertions(curNode.right, n, insertions);
    }
    
    public void copyTree(TreeNode curNode, TreeNode copyNode)
    {
        if (curNode == null)
            return;
        
        copyNode.val = curNode.val;
        
        if (curNode.left != null)
        {
            copyNode.left = new TreeNode();
            copyTree(curNode.left, copyNode.left);
        }
        
        if (curNode.right != null)
        {
            copyNode.right = new TreeNode();
            copyTree(curNode.right, copyNode.right);
        }
    }
}