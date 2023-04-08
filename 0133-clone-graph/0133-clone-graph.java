class Solution {
    Map<Node, Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node curr) {
        if (curr == null)
            return null;
        
        if (oldToNew.containsKey(curr))
            return oldToNew.get(curr);
        
        Node newNode = new Node(curr.val, new ArrayList<>());
        oldToNew.put(curr, newNode);
        for (Node nbr : curr.neighbors)
            newNode.neighbors.add(cloneGraph(nbr));
        return newNode;
    }
}