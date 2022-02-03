class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> count1 = new HashMap<>();
        HashMap<Integer, Integer> count2 = new HashMap<>();
        int n = nums1.length;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                count1.put(nums1[i] + nums2[j], count1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                count2.put(nums3[i] + nums4[j], count2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        
        // System.out.println(count1);
        // System.out.println(count2);
        
        int res = 0;
        for (int key : count1.keySet())
        {
            res += (count1.get(key) * count2.getOrDefault(-key, 0));
        }
        
        return res;
    }
}