class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode iter = head;
        ListNode prev = new ListNode();
        prev.next = head;
        
        for(int i = 0; i < m - 1; i++) {
            prev = prev.next;
            iter = iter.next;
        }
        
        Stack<ListNode> reverseOrder = new Stack<>();
        for(int i = 0; i < n - m + 1; i++) {
            reverseOrder.push(iter);
            iter = iter.next;
        }
        
        ListNode result = (m == 1) ? reverseOrder.peek() : head;
        
        while(!reverseOrder.isEmpty()) {
            prev.next = reverseOrder.pop();
            prev = prev.next;
        }
        prev.next = iter;
        
        return result;
    }
}