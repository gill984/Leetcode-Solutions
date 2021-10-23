class Solution {
    public Node connect(Node root)
    {
        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level

        while (cur != null)
        {
            while (cur != null)
            { //iterate on the current level
                if (cur.left != null)
                {
                    if (prev == null)
                        head = cur.left;
                    else
                        prev.next = cur.left;
                    prev = cur.left;
                }
                
                if (cur.right != null)
                {
                    if (prev == null)
                        head = cur.right;
                    else
                        prev.next = cur.right;
                    prev = cur.right;
                }
                
                cur = cur.next;
            }
            
            cur = head;
            head = null;
            prev = null;
        }
        
        return root;
    }
}