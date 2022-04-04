class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null)
            return head;
        
        int length = getLength(head);
        ListNode first = head;
        for (int i = 1; i < k; i++)
            first = first.next;
        
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++)
            second = second.next;
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
    
    public int getLength(ListNode head)
    {
        int length = 0;
        while (head != null)
        {
            head = head.next;
            length++;
        }
        
        return length;
    }
}