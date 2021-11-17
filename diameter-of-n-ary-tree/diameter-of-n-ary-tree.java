/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max;
    public int diameter(Node root) {
        max = 0;
        dfs(root);
        return max;
    }
    
    public int dfs (Node curr)
    {
        if (curr == null)
            return 0;
        
        List<Integer> childLengths = new ArrayList<Integer>();
        int [] maxTwo = new int [2];
        for (Node child : curr.children)
        {
            int l = dfs(child);
            if (l > maxTwo[0])
            {
                maxTwo[1] = maxTwo[0];
                maxTwo[0] = l;
            }
            else if (l > maxTwo[1])
            {
                maxTwo[1] = l;
            }
        }
        
        // max could be the max through this node as the elbox
        max = Math.max(maxTwo[0] + maxTwo[1], max);
        
        // max length to the bottom
        return maxTwo[0] + 1;
    }
}