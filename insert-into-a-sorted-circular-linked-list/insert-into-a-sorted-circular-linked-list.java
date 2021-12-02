/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution 
{
    public Node insert(Node head, int insertVal)
    {
        // If the list is empty, create a new cyclic list
        // So create a new node which points to itself.
        if(head == null)
        {
            Node res = new Node(insertVal, null);
            res.next = res;
            return res;
        }
        
        // Now handle case where we have at least 1 node
        // Iterate through list until spot is found where either there are 2 nodes in order n1 -> n2 and n1.val <= insertVal < n2.val
        // Or n1.val < insertVal, n1.val > n2.val
        Node lo = head;
        Node hi = head.next;
        
        while(true)
        {
            // If insertVal is between lo and hi OR insert val is bigger than or equal to lo and hi < lo (end of list) OR We have hit the end of the list.
            if((lo.val <= insertVal && insertVal <= hi.val) || (hi.val < lo.val && (insertVal >= lo.val || insertVal <= hi.val)) || ((hi.next == head) && (hi.val == head.val)))
            {
                Node insertNode = new Node(insertVal, hi);
                lo.next = insertNode;
                return head;
            }
            
            lo = lo.next;
            hi = hi.next;
        }
    }
}