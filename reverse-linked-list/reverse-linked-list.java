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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode iter = head;
        while (iter != null)
        {
            stack.push(iter);
            iter = iter.next;
        }
        
        ListNode res = stack.pop();
        ListNode prev = res;
        ListNode cur = null;
        while (!stack.isEmpty())
        {
            cur = stack.pop();
            prev.next = cur;
            cur.next = null;
            prev = cur;
        }
        
        return res;
    }
}