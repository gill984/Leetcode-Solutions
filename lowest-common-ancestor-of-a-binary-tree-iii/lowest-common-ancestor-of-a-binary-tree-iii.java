/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> pAncestors = new HashSet<>();
        pAncestors.add(p.val);
        Node curr = p;
        while (curr.parent != null)
        {
            curr = curr.parent;
            pAncestors.add(curr.val);
        }
        
        curr = q;
        while (!pAncestors.contains(curr.val))
            curr = curr.parent;
        
        return curr;
    }
}