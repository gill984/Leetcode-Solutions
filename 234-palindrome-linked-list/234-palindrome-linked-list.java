class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        
        int lo = 0;
        int hi = l.size() - 1;
        while (lo < hi) {
            if (l.get(lo) != l.get(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
}