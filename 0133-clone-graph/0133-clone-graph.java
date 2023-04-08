class Solution {
    
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
    
    public Node dfs(Node curr, Map<Node, Node> oldToNew) {
        if (curr == null)
            return null;
        
        if (oldToNew.containsKey(curr))
            return oldToNew.get(curr);
        
        Node newNode = new Node(curr.val, new ArrayList<>());
        oldToNew.put(curr, newNode);
        for (Node nbr : curr.neighbors)
            newNode.neighbors.add(dfs(nbr, oldToNew));
        return newNode;
    }
}