class Solution {
    public int pairSum(ListNode head) {
        int n = getLength(head);
        int half = n / 2;
        ListNode halfStart = head;
        for (int i = 0; i < half; i++) {
            halfStart = halfStart.next;
        }
        
        // Reverse list from halfStart to the end
        halfStart = reverseList(halfStart);
        
        ListNode a = head;
        ListNode b = halfStart;
        int res = 0;
        
        for (int i = 0; i < half; i++) {
            res = Math.max(res, a.val + b.val);
            a = a.next;
            b = b.next;
        }
        
        return res;
    }
    
    public ListNode reverseList(ListNode halfStart) {
        ListNode curr = halfStart;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    public int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}