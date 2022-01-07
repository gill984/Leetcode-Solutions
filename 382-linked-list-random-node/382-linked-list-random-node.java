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
class Solution
{
    List<Integer> vals;
    Random gen;
    
    public Solution(ListNode head)
    {
        vals = new ArrayList<>();
        gen = new Random();
        ListNode curr = head;
        
        while (curr != null)
        {
            vals.add(curr.val);
            curr = curr.next;
        }
    }
    
    public int getRandom()
    {
        return vals.get(gen.nextInt(vals.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */