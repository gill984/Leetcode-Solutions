class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null)
        {
            // System.out.println(curr.val);
            if (curr.next == null)
                break;
            
            if (curr.val == curr.next.val)
            {
                // System.out.println("Prev: " + prev != null ? prev.val : "null");
                // System.out.println("curr: " + curr.val);
                curr = nextDifferent(curr.val, curr);
                if (prev != null)
                    prev.next = curr;
                else
                    head = curr;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
    
    
    
    public ListNode nextDifferent(int val, ListNode n) {
        if (n == null)
            return null;
        else if (n.val == val)
            return nextDifferent(val, n.next);
        else
            return n;
    }
}