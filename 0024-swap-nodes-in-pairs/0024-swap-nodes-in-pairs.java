class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode first = curr;
            ListNode second = curr.next;
            if (second == null) {
                break;
            }
            
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }
            
            
            first.next = second.next;
            second.next = first;
            prev = first;
            curr = first.next;
        }
        
        return head;
    }
}