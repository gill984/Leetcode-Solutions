class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : nums)
        {
            if (count.containsKey(i))
            {
                if (k == 0 && count.get(i) == 1)
                    res++;
            }
            else if (k != 0)
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