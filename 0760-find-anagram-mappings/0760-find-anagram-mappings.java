class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
            valToIndex.put(nums2[i], i);
        
        int [] mapping = new int [n];
        for (int i = 0; i < n; i++)
            mapping[i] = valToIndex.get(nums1[i]);
        return mapping;
    }
}