class Solution
{
    public Node copyRandomList(Node head)
    {
        if(head == null)
            return null;
        
        // Map from old version of node to new copy version of that same node
        Map <Node, Node> oldToNew = new HashMap<Node, Node>();
        
        // Iterate through the original list
        // If oldToNew does not contain old.next, create a new copy and put in map <old.next, new.next>
        // Else set new.next to the value pointed to by oldToNew.get(old.next)
        Node res = new Node(head.val);
        oldToNew.put(head, res);
        Node iter = res;
        Node old = head;
        
        while(old != null)
        {
            // Populate the next field
            if(old.next == null)
            {
                iter.next = null;
            }
            else if(!oldToNew.containsKey(old.next))
            {
                iter.next = new Node(old.next.val);
                oldToNew.put(old.next, iter.next);
            }
            else
            {
                iter.next = oldToNew.get(old.next);
            }
            
            // Populate the random field
            if(old.random == null)
            {
                iter.random = null;
            }
            else if(!oldToNew.containsKey(old.random))
            {
                iter.random = new Node(old.random.val);
                oldToNew.put(old.random, iter.random);
            }
            else
            {
                iter.random = oldToNew.get(old.random);
            }
            
            old = old.next;
            iter = iter.next;
        }
        
        return res;
    }
}