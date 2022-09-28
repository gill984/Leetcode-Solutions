class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n + 1; i++)
        {
            if (fast != null)
                fast = fast.next;
            else
                return head.next;
        }
        
        while (fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}