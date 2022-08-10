# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self.toBst(nums, 0, len(nums) - 1)
    
    def toBst(self, nums, lo, hi):
        if lo > hi:
            return None
        
        mid = (lo + hi) // 2
        curr = TreeNode(nums[mid])
        curr.left = self.toBst(nums, lo, mid - 1)
        curr.right = self.toBst(nums, mid + 1, hi)        
        return curr