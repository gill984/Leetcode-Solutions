class Solution
{
    HashMap<TreeNode, HashMap<Integer, Integer>> nodeMap = new HashMap<TreeNode, HashMap<Integer, Integer>>();
        
    public int pathSum(TreeNode root, int sum)
    {        
        // For each node from the root down in a dfs fashion
        //     Create a hashmap for this node which maps each potential sum to the frequency of that sum given that this node is the end of the path
        //     In order to populate this hashmap, use the parent map which will be passed in to the search function
        //     The resulting hashmap always also contains the path formed by this node in isolation
        dfs(root, sum, null);
        
        int res = 0;
        for(TreeNode t : nodeMap.keySet())
        {
            if(nodeMap.get(t).containsKey(sum))
            {
                res += nodeMap.get(t).get(sum);
            }
        }
        
        return res;
    }
    
    // Return the number 
    public void dfs(TreeNode pathEnd, int target, HashMap<Integer, Integer> parentMap)
    {
        if(pathEnd == null)
            return;
        
        HashMap<Integer, Integer> sumToFreq = new HashMap<Integer, Integer>();
        
        
        if(parentMap != null)
        {
            for(int parentSum : parentMap.keySet())
                sumToFreq.put(parentSum + pathEnd.val, parentMap.get(parentSum));
        }
                
        // Add this value in isolation
        if(sumToFreq.containsKey(pathEnd.val))
            sumToFreq.put(pathEnd.val, sumToFreq.get(pathEnd.val) + 1);
        else
            sumToFreq.put(pathEnd.val, 1);
        
        nodeMap.put(pathEnd, sumToFreq);
        
        if(pathEnd.left != null)
            dfs(pathEnd.left, target, sumToFreq);
        if(pathEnd.right != null)
            dfs(pathEnd.right, target, sumToFreq);
        
        return;
    }
}