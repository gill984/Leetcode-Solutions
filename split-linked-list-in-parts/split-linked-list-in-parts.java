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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null)
            return new ListNode [k]; 
        // Get length of list
        ListNode iter = head;
        int length = 0;
        while (iter != null)
        {
            iter = iter.next;
            length++;
        }
        
        // Base size of every group and how many groups need an extra
        // member to make things work out correctly
        int groupSize = length / k;
        int groupCorrection = length - (k * groupSize);
        
        iter = head;
        ListNode[] res = new ListNode[k];
        ListNode prev = null;
        for (int i = 0; i < k; i++)
        {
            res[i] = iter;
            for (int j = 0; iter != null && j < groupSize + (groupCorrection > 0 ? 1 : 0); j++)
            {
                prev = iter;
                iter = iter.next;
            }
            
            // iter is pointing to the last element in this group
            // need to update to the first element in the next group
            // and modify the list
            prev.next = null;
            
            if (groupCorrection > 0)
                groupCorrection--;
        }
        
        return res;
    }
}