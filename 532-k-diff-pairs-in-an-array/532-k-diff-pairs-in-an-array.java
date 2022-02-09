class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : nums)
        {
            if (k == 0 && count.getOrDefault(i, 0) == 1)
                res++;
            
            if (k != 0 && !count.containsKey(i))
            {
                int search1 = i - k;
                if (count.containsKey(search1))
                {
                    res++;
                }

                int search2 = i + k;
                if (count.containsKey(search2))
                {
                    res++;
                }
            }
            
            
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        return res;
    }
}