class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<Node, Node>();
        dfsCloneGraph(node, oldToNew);
        return oldToNew.get(node);
    }
    
    public void dfsCloneGraph(Node oldNode, Map<Node, Node> oldToNew)
    {
        boolean newNodeExists = oldToNew.containsKey(oldNode);
        if (!newNodeExists)
            oldToNew.put(oldNode, new Node(oldNode.val));
        
        Node clone = oldToNew.get(oldNode);
        for (Node nbr : oldNode.neighbors)
        {
            boolean newNbrNodeExists = oldToNew.containsKey(nbr);
            if (!newNbrNodeExists)
            {
                oldToNew.put(nbr, new Node(nbr.val));
                dfsCloneGraph(nbr, oldToNew);
            }
            clone.neighbors.add(oldToNew.get(nbr));
        }
    }
}