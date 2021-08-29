class Solution
{
    final int INIT = -1;
    int total = INIT;
    int target1 = INIT;
    int target2 = INIT;
    int result = INIT;
    
    public int maxProduct(TreeNode root)
    {
        // First run just finds total
        total = findSumRecurse(root);
        target1 = total / 2;
        target2 = total / 2;
        if (total % 2 == 1)
            target2 += 1;
        
        // Second run finds best candidate for split
        // an alternative to this would be to store all the sums found in the first run
        // this turns out to be faster on leetcode than creating a hashset and iterating through it
        findSumRecurse(root);
        
        // Use longs to avoid overflow problems
        long m1 = result;
        long m2 = total - result;
        long MOD = 1000000007L; 
        return (int)((m1 * m2) % MOD);
    }
    
    public int findSumRecurse(TreeNode n)
    {
        int sum = 0;
        if (n != null)
            sum = n.val + findSumRecurse(n.left) + findSumRecurse(n.right);
        
        // Only runs if this is the second call to this recursive function
        if (total != INIT && (result == INIT || Math.abs(sum - target1) < Math.abs(result - target1) || Math.abs(sum - target2) < Math.abs(result - target2)))
            result = sum;
        
        return sum;
    }
}