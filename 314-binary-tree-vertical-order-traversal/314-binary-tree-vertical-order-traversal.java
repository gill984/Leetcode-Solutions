class Solution {
    int minColumn;
    int maxColumn;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        
        Map<Integer, List<Integer>> columnToList = new HashMap<Integer, List<Integer>>();
        minColumn = 0;
        maxColumn = 0;
        createColumnMap(root, columnToList);
        
        for (int i = minColumn; i <= maxColumn; i++)
            result.add(columnToList.get(i));
        return result;
    }
    
    public void createColumnMap(TreeNode root, Map<Integer, List<Integer>> columnToList)
    {
        Queue<Pair> bfs = new ArrayDeque<Pair>();
        bfs.offer(new Pair(root, 0));
        while(!bfs.isEmpty())
        {
            Pair curr = bfs.poll();
            minColumn = Math.min(curr.column, minColumn);
            maxColumn = Math.max(curr.column, maxColumn);
            
            if (!columnToList.containsKey(curr.column))
                columnToList.put(curr.column, new ArrayList<Integer>());
            columnToList.get(curr.column).add(curr.node.val);
            if (curr.node.left != null)
                bfs.offer(new Pair(curr.node.left, curr.column - 1));
            if (curr.node.right != null)
                bfs.offer(new Pair(curr.node.right, curr.column + 1));
        }
    }
}

class Pair
{
    int column;
    TreeNode node;
    
    public Pair(TreeNode node, int c)
    {
        this.column = c;
        this.node = node;
    }
}