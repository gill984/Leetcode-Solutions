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
class Solution {
    public ListNode oddEvenList(ListNode head)
    {
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        
        if (head == null)
            return head;
        
        int index = 1;
        ListNode curr = head;
        
        while (curr != null)
        {
            if (index % 2 == 1)
            {
                if (oddHead == null)
                {
                    oddHead = curr;
                    oddTail = curr;
                }
                else
                {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            else
            {
                if (evenHead == null)
                {
                    evenHead = curr;
                    evenTail = curr;
                }
                else
                {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            
            curr = curr.next;
            index++;
        }
        
        oddTail.next = evenHead;
        
        if (evenTail != null)
            evenTail.next = null;
        
        return oddHead;
    }
}