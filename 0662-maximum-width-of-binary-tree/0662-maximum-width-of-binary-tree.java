class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        List<Integer> nextLevelIndexes = new ArrayList<>();
        int res = 1;
        nextLevelNodes.add(root);
        nextLevelIndexes.add(1);
        
        while (!nextLevelNodes.isEmpty()) {
            List<TreeNode> nodes = nextLevelNodes;
            List<Integer> indexes = nextLevelIndexes;
            nextLevelNodes = new ArrayList<>();
            nextLevelIndexes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode curr = nodes.get(i);
                int idx = indexes.get(i);
                
                if (curr.left != null) {
                    nextLevelNodes.add(curr.left);
                    nextLevelIndexes.add(idx * 2);
                }
                
                if (curr.right != null) {
                    nextLevelNodes.add(curr.right);
                    nextLevelIndexes.add(idx * 2 + 1);
                }
            }
            
            res = Math.max(indexes.get(indexes.size() - 1) - indexes.get(0) + 1, res);
        }
        
        return res;
    }
}