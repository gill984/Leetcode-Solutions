# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    pList = []
    qList = []
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.dfsLca(root, p, q, [])
        
        n = min(len(self.pList), len(self.qList))
        for i in range(n):
            if self.pList[n - i - 1] is self.qList[n - i - 1]:
                return self.pList[n - i - 1]
        return None
    
    def dfsLca(self, curr, p, q, l):
        if curr is None:
            return
        
        l.append(curr)
        if curr is p:
            self.pList = l.copy()
        if curr is q:
            self.qList = l.copy()
        
        self.dfsLca(curr.left, p, q, l)
        self.dfsLca(curr.right, p, q, l)
        l.pop()
        return