class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        
        for (int i : nums) {
            if (count.containsKey(k - i)) {
                count.put(k - i, count.get(k - i) - 1);
                if (count.get(k - i) == 0) {
                    count.remove(k - i);
                }
                res += 1;
            } else {
                count.put(i, count.getOrDefault(i, 0) + 1);
            }
        }
        
        return res;
    }
}