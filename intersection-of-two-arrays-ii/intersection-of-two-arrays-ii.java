class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] count = new int[1001];
        
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]] += 1;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (count[nums2[i]] > 0) {
                list.add(nums2[i]);
                count[nums2[i]]--;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        
        return res;
    }
}