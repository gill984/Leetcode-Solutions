public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        
        ListNode iter = headA;
        while (iter != null) {
            aLength++;
            iter = iter.next;
        }
        
        iter = headB;
        while (iter != null) {
            bLength++;
            iter = iter.next;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        for (int i = 0; i < aLength - bLength; i++)
            a = a.next;
        
        for (int i = 0; i < bLength - aLength; i++)
            b = b.next;
        
        while (a != null && b != null) {
            if (a == b)
                return a;
            
            a = a.next;
            b = b.next;
        }
        
        return null;
    }
}