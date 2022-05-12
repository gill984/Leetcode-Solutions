class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return perms;
        
        Set<Integer> indices = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            indices.add(i);
        
        List<Integer> curList = new ArrayList<Integer>();
        dfsPermutations(nums, curList, indices, perms);
        return perms;
    }
    
    public void dfsPermutations(int [] nums, List<Integer> curList, Set<Integer> indices, List<List<Integer>> perms)
    {
        if (curList.size() == nums.length)
        {
            perms.add(new ArrayList<Integer>(curList));
            return;
        }
        
        Set<Integer> used = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (indices.contains(i) && !used.contains(nums[i]))
            {
                used.add(nums[i]);
                curList.add(nums[i]);
                indices.remove(i);
                dfsPermutations(nums, curList, indices, perms);
                curList.remove(curList.size() - 1);
                indices.add(i);
            }
        }
    }
}
