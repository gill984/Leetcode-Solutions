class SparseVector {
    final int INDEX = 0;
    final int VALUE = 1;
    
    public List<int[]> indexValues;
    
    SparseVector(int[] nums)
    {
        indexValues = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
                indexValues.add(new int [] {i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec)
    {
        int res = 0;
        List<int[]> indexValues2 = vec.indexValues;
        int i = 0;
        int j = 0;
        while (i < indexValues.size() && j < indexValues2.size())
        {
            int[] p1 = indexValues.get(i);
            int[] p2 = indexValues2.get(j);
            
            if (p1[INDEX] < p2[INDEX])
                i++;
            else if (p2[INDEX] < p1[INDEX])
                j++;
            else
            {
                res += (p1[VALUE] * p2[VALUE]);
                i++;
                j++;
            }
        }
        
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);