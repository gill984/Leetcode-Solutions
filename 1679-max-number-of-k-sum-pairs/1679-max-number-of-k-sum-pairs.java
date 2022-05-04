class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        
        for (int i : nums) {
            if (count.getOrDefault(k - i, 0) > 0) {
                count.put(k - i, count.get(k - i) - 1);
                res += 1;
            } else {
                count.put(i, count.getOrDefault(i, 0) + 1);
            }
        }
        
        return res;
    }
}