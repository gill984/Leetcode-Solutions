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
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast)
        {
            if (fast == null)
                return false;
            fast = fast.next;
            
            if (fast == null)
                return false;
            fast = fast.next;
            
            slow = slow.next;
            
            // System.out.println("fast: " + fast.val);
            // System.out.println("slow: " + slow.val);
        }
        
        return true;
    }
}