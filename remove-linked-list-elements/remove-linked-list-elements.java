class Solution
{
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null)
        {
            if (cur.val == val)
            {
                if (prev != null)
                {
                    prev.next = cur.next;
                }
                else
                {
                    head = cur.next;
                }
            }
            else
            {
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}