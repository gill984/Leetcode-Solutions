/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    
    HashMap<Integer, Integer> preIndex = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> inIndex = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        // Recursively solve for the left and right subtrees, pass in the new preorder and postorder arrays to the function
        
        // Pre-process indices, since values are unique
        for(int i = 0; i < preorder.length; i++)
        {
            preIndex.put(preorder[i], i);
            inIndex.put(inorder[i], i);
        }
        
        
        return buildTreeRecurse(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    public TreeNode buildTreeRecurse(int [] preorder, int[] inorder, int preLo, int preHi, int inLo, int inHi)
    {
        if(preLo < 0 || preLo >= preorder.length || preLo >= preHi || inLo >= inHi)
            return null;
        
        TreeNode root = new TreeNode(preorder[preLo]);
        
        int preRoot = preIndex.get(root.val);
        int inRoot = inIndex.get(root.val);
        
        // inorder left subtree is all elements before index inRoot
        // inorder right subtree is all elements after index inRoot
        int leftInLo = inLo;
        int leftInHi = inRoot;
        int rightInLo = inRoot + 1;
        int rightInHi = inHi;
        
        // preorder left subtree is next size(inorder left subtree) elements in preorder array after preRoot
        // preorder right subtree is remaining elements in preorder array
        int leftPreLo = preLo + 1;
        int leftPreHi = (leftInHi - leftInLo) + leftPreLo;
        int rightPreLo = leftPreHi;
        int rightPreHi = preHi;
        
        // System.out.println("=========================");
        // System.out.println("leftInLo: " + leftInLo);
        // System.out.println("leftInHi: " + leftInHi);
        // System.out.println("rightInLo: " + rightInLo);
        // System.out.println("rightInHi: " + rightInHi);
        // System.out.println("leftPreLo: " + leftPreLo);
        // System.out.println("leftPreHi: " + leftPreHi);
        // System.out.println("rightPreLo: " + rightPreLo);
        // System.out.println("rightPreHi: " + rightPreHi);
        // System.out.println("=========================");
        
        root.left = buildTreeRecurse(preorder, inorder, leftPreLo, leftPreHi, leftInLo, leftInHi);
        root.right = buildTreeRecurse(preorder, inorder, rightPreLo, rightPreHi, rightInLo, rightInHi);
        
        return root;
    }
}