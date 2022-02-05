class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode l : lists)
            if (l != null)
                q.offer(l);
        
        ListNode head = null;
        ListNode iter = null;
        while (!q.isEmpty())
        {
            ListNode min = q.poll();
            
            if (iter != null)
            {
                iter.next = min;
                iter = iter.next;
            }
            else
            {
                iter = min;
                head = min;
            }
            
            if (min.next != null)
            {
                q.offer(min.next);
            }
        }
        
        return head;
    }
}