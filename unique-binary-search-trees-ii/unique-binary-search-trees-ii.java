/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public List<TreeNode> generateTrees(int n)
    {
        if(n == 0)
            return new ArrayList<TreeNode>();
        
        List<List<TreeNode>> trees = new ArrayList<List<TreeNode>>();
        for(int i = 0; i < n; i++)
            trees.add(new ArrayList<TreeNode>());
        
        // Base case tree
        TreeNode root = new TreeNode(1);
        trees.get(0).add(root);
        
        for(int numNodes = 1; numNodes < n; numNodes++)
        {
            // Add this next node as a root, bottom right child, and at each right edge with only
            // left parents to all previous trees with 1 less nodes
            // These are the only locations where the largest node in a binary search tree can be placed
            for(TreeNode base : trees.get(numNodes - 1))
            {
                // First add the tree where this new node is the root and the whole left subtree is base
                TreeNode bigRoot = new TreeNode(numNodes + 1);
                bigRoot.left = copyTree(base);
                trees.get(numNodes).add(bigRoot);
                
                // Now Try adding this node as each right child which only has left parents
                STEPS:
                for(int steps = 0; ; steps++)
                {
                    TreeNode copy = copyTree(base);
                    TreeNode iter = copy;
                    
                    // Try going right steps number of times
                    boolean finished = false;
                    for(int i = 0; i < steps; i++)
                    {
                        if(iter.right != null)
                            iter = iter.right;
                        else
                        {
                            break STEPS;
                        }
                    }
                    
                    TreeNode biggest = new TreeNode(numNodes + 1);
                    biggest.left = iter.right;
                    iter.right = biggest;
                    trees.get(numNodes).add(copy);
                }
            }
        }
        
        return trees.get(n - 1);
    }
    
    public TreeNode copyTree(TreeNode root)
    {
        if(root == null)
            return null;
        
        TreeNode result = new TreeNode(root.val);
        result.left = copyTree(root.left);
        result.right = copyTree(root.right);
        
        return result;
    }
}