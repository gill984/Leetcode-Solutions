/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        // Create a priority queue of size lists.length
        // Add the first element of each list to the queue
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((x, y) -> Integer.compare(x.val, y.val));
        
        for(int i = 0; i < lists.length; i++)
        {
            ListNode l = lists[i];
            if(l != null)
                minHeap.offer(l);
        }
        
        ListNode result = null;
        ListNode prev = null;
        while(!minHeap.isEmpty())
        {
            ListNode nextSmallest = minHeap.poll();
            if(result == null)
            {
                result = nextSmallest;
            }
            
            if(prev != null)
            {
                prev.next = nextSmallest;
            }
            prev = nextSmallest;
            
            if(nextSmallest.next != null)
            {
                minHeap.offer(nextSmallest.next);
            }
        }
        
        return result;
    }
}