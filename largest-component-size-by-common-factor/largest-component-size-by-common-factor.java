class Solution
{
    public int largestComponentSize(int[] nums)
    {
        // Want the size of the largest component in the subgraph
        // Can run union find then call root on each element to determine component
        // If gcd(a, b) > 1, then there is an edge between these numbers
        int n = nums.length;
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++)
            maxValue = Math.max(maxValue, nums[i]);
        UF disjointSet = new UF(maxValue + 1);
        
        for (int num : nums)
        {
            for (int factor = 2; factor < (int)(Math.sqrt(num)) + 1; factor++)
            {
                if (num % factor == 0)
                {
                    disjointSet.union(num, factor);
                    disjointSet.union(num, num / factor);
                }
            }
        }
        
        return disjointSet.largestComponent(nums);
    }
}

class UF
{
    // Disjoint set
    int [] ds;
    int [] size;
    
    public UF(int size)
    {
        ds = new int [size];
        for (int i = 0; i < size; i++)
            ds[i] = i;
    }
    
    public int findRoot(int a)
    {
        int res = a;
        while (a != ds[a])
        {
            a = ds[a];
            ds[a] = ds[ds[a]];
        }
        
        return a;
    }
        
    public void union(int a, int b)
    {
        ds[findRoot(a)] = findRoot(b);
    }
    
    public int largestComponent(int [] nums)
    {
        int res = 1;
        int [] count = new int [ds.length];
        for (int num : nums)
        {
            int root = findRoot(num);
            count[root]++;
            res = Math.max(res, count[root]);
        }
        
        return res;
    }
}