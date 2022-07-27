class Solution:
    curr = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        self.flattenLeft(root)
        iter = root
        while iter is not None:
            iter.right = iter.left
            iter.left = None
            iter = iter.right
        
    def flattenLeft(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return
        
        if self.curr is not None:
            self.curr.left = root
        self.curr = root
        
        self.flattenLeft(root.left)
        self.flattenLeft(root.right)