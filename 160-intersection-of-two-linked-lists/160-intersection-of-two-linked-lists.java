public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode iter = headA;
        while (iter != null) {
            visited.add(iter);
            iter = iter.next;
        }
        
        iter = headB;
        while (iter != null) {
            if (visited.contains(iter)) {
                return iter;
            }
            iter = iter.next;
        }
        
        return null;
    }
}