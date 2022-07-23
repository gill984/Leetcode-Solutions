class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        
        // Use mergesort algorithm to solve this problem
        // sort in increasing order
        // when a swap happens, increase the count for the index being swapped from left to right
        // During the fill part of merge sort
        int [] result = new int[nums.length];
        Pair [] pairs = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++)
            pairs[i] = new Pair(i, nums[i]);
        
        mergeSortCount(0, nums.length - 1, pairs, result);
        List<Integer> l = new ArrayList<Integer>();
        for(int i : result)
            l.add(i);
        return l;
    }
    
    public Pair[] mergeSortCount(int lo, int hi, Pair[] pairs, int [] result)
    {
        // Single element case, recurse back up
        if(lo == hi)
        {
            Pair [] single = new Pair[1];
            single[0] = pairs[lo];
            return single;
        }
        Pair [] left = mergeSortCount(lo, (hi + lo) / 2, pairs, result);
        Pair [] right = mergeSortCount((hi + lo)/ 2 + 1, hi, pairs, result);
        Pair [] sorted = new Pair[left.length + right.length];
        
        // Do the merge part
        int ldx = 0;
        int rdx = 0;
        int sdx = 0;
        while(ldx < left.length && rdx < right.length)
        {
            if(left[ldx].val > right[rdx].val)
            {
                sorted[sdx] = left[ldx];
                result[left[ldx].idx] += (right.length - rdx);
                ldx++;
            }
            else
            {
                sorted[sdx] = right[rdx];
                rdx++;
            }
            sdx++;
        }
        
        while(ldx < left.length)
            sorted[sdx++] = left[ldx++];
        while(rdx < right.length)
            sorted[sdx++] = right[rdx++];
        
        return sorted;
    }
}

class Pair
{
    int idx;
    int val;
    
    public Pair(int i, int v)
    {
        idx = i;
        val = v;
    }
}