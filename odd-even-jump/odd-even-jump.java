class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        
        // TreeMap in java is basically a BST ordered on key values
        // insertion is log(n), lookup is log(n)
        TreeMap<Integer, Integer> valueToIndex = new TreeMap<>();
        boolean [] oddSuccess = new boolean [arr.length];
        boolean [] evenSuccess = new boolean [arr.length];
        oddSuccess[n - 1] = true;
        evenSuccess[n - 1] = true;
        
        // Go backwards because each index can only jump to later indices
        for (int i = n - 1; i >= 0; i--)
        {            
            // Check odd jump, ceilingKey gives smallest key >= arr[i]
            Integer higher = valueToIndex.ceilingKey(arr[i]);
            if (higher != null)
                oddSuccess[i] = evenSuccess[valueToIndex.get(higher)];
            
            // Check even jump, floorKey gives largest key <= arr[i]
            Integer lower = valueToIndex.floorKey(arr[i]);
            if (lower != null)
                evenSuccess[i] = oddSuccess[valueToIndex.get(lower)];
            
            // Replace old value if there is one, we always want to jump
            // to the smallest possible index. Since we're iterating backwards
            // this is the smallest index we've examined so far.
            valueToIndex.put(arr[i], i);
        }
        
        // An odd success means you can do your first jump from this index
        // and reach the end, the problem asks for good starting indices.
        int res = 0;
        for (int i = 0; i < n; i++)
            if (oddSuccess[i])
                res++;
        
        return res;
    }
}