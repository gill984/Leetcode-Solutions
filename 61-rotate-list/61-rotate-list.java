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
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null)
            return null;
        
        ListNode tail = head;
        int count = 1;
        while(tail.next != null)
        {
            tail = tail.next;
            count++;
        }
        
        // Turn this list into a circular list
        // Rotating is circular so we only need to rotate count % k times
        k = k % count;
        tail.next = head;
        
        // The newTail is the element (count - k - 1) elements
        // to the right of the current head
        tail = head;        
        for(int i = 0; i < count - k - 1; i++)
            tail = tail.next;
        
        // Order is important here, need to set the newHead then
        // set newTail's next pointer to null
        head = tail.next;
        tail.next = null;
        return head;
    }
}