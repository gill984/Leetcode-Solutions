# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        ps = set()
        self.dfsP(root, p, ps)
        # print([x.val for x in ps])
        return self.dfsQ(root, q, ps)[1]
    
    def dfsP(self, curr, target, ps):
        if curr is None:
            return False
        
        if curr is target:
            ps.add(curr)
            return True
        else:
            isParent = self.dfsP(curr.left, target, ps) or self.dfsP(curr.right, target, ps)
            if isParent:
                ps.add(curr)
            return isParent
        
    def dfsQ(self, curr, target, ps):
        if curr is None:
            return [False, None]
        
        if curr is target:
            return [True, curr if curr in ps else None]
        
        left = self.dfsQ(curr.left, target, ps)
        if left[0]:
            if left[1] == None and curr in ps:
                left[1] = curr
            return left
        
        right = self.dfsQ(curr.right, target, ps)
        if right[0]:
            if right[1] == None and curr in ps:
                right[1] = curr
            return right
        
        return [False, None]
        