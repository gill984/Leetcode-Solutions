class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> valueToIndex = new TreeMap<>();
        boolean [] oddSuccess = new boolean [arr.length];
        boolean [] evenSuccess = new boolean [arr.length];
        oddSuccess[n - 1] = true;
        evenSuccess[n - 1] = true;
        
        for (int i = n - 1; i >= 0; i--)
        {            
            // Check odd jump, higherKey
            Integer higher = valueToIndex.ceilingKey(arr[i]);
            if (higher != null)
                oddSuccess[i] = evenSuccess[valueToIndex.get(higher)];
            
            // Check even jump, lowerKey
            Integer lower = valueToIndex.floorKey(arr[i]);
            if (lower != null)
                evenSuccess[i] = oddSuccess[valueToIndex.get(lower)];
            
            valueToIndex.put(arr[i], i);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++)
            if (oddSuccess[i])
                res++;
        
        return res;
    }
}