class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Perform a dual inorder traversal
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = toList(root1);
        List<Integer> list2 = toList(root2);
        res = merge(list1, list2);
        return res;
    }
    
    public List<Integer> toList(TreeNode root)
    {
        // Perform an inorder traversal to generate the list
        List<Integer> res = new ArrayList<>();
        if (root == null)
        {
            return res;
        }
        
        res.addAll(toList(root.left));
        res.add(root.val);
        res.addAll(toList(root.right));
        
        return res;
    }
    
    // Merge 2 sorted lists
    public List<Integer> merge (List<Integer> list1, List<Integer> list2)
    {
        List<Integer> res = new ArrayList<>();
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (idx1 < list1.size() && idx2 < list2.size())
        {
            if (list1.get(idx1) < list2.get(idx2))
            {
                res.add(list1.get(idx1));
                idx1++;
            }
            else
            {
                res.add(list2.get(idx2));
                idx2++;
            }
        }
        
        while (idx1 < list1.size())
        {
            res.add(list1.get(idx1));
            idx1++;
        }
        
        while (idx2 < list2.size())
        {
            res.add(list2.get(idx2));
            idx2++;
        }
        
        return res;
    }
}