# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        res = None
        less = None
        more = None
        moreStart = None
        curr = head
        
        while curr is not None:
            if curr.val < x:
                if less is None:
                    less = curr
                    res = less
                else:
                    less.next = curr
                    less = less.next
            else:
                if more is None:
                    more = curr
                    moreStart = more
                else:
                    more.next = curr
                    more = more.next
            
            curr = curr.next
        
        if less is not None:
            less.next = moreStart
            
        if more is not None:
            more.next = None
        
        return res if res is not None else moreStart