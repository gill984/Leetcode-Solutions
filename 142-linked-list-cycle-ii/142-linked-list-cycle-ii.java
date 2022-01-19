/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        HashSet<ListNode> visited = new HashSet<ListNode>();
        
        while(head != null)
        {
            if(visited.contains(head))
                return head;
            
            visited.add(head);
            head = head.next;
        }
        
        return null;
    }
}