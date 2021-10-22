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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null)
        {
            stack1.push(l1);
            l1 = l1.next;
        }
        
        while (l2 != null)
        {
            stack2.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode prev = null;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            cur = new ListNode();
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            cur.val = val1 + val2 + carry;
            carry = 0;
            if (cur.val >= 10)
            {
                cur.val -= 10;
                carry = 1;
            }
            cur.next = prev;
            prev = cur;
        }
        
        if (carry == 1)
        {
            cur = new ListNode(1);
            cur.next = prev;
        }
        
        return cur;
    }
}