/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // Map each depth to the sum of integers at that depth
        // Keep track of max depth
        int[] depthSum = new int[51];
        maxDepth = 1;
        dfs(nestedList, 1, depthSum);
        
        // iterate through map and calculate result at the end
        int res = 0;
        for (int d = 0; d < depthSum.length; d++)
        {
            res += ((maxDepth - d + 1) * depthSum[d]);
        }
        
        return res;
    }
    
    public void dfs(List<NestedInteger> list, int depth, int[] depthSum)
    {
        maxDepth = Math.max(maxDepth, depth);
        
        for (NestedInteger ni : list)
        {
            if (ni.isInteger())
            {
                depthSum[depth] += ni.getInteger();
            }
            else
            {
                dfs(ni.getList(), depth + 1, depthSum);
            }
        }
    }
}





























