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
    int length;
    List<Integer> arr;
    Random r;
    
    public Solution(ListNode head) {
        r = new Random();
        ListNode curr = head;
        arr = new ArrayList<>();
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }
    }
    
    public int getRandom() {
        int idx = r.nextInt(arr.size());
        return arr.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */