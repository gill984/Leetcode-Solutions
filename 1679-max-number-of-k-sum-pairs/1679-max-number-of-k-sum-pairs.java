class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        int res = 0;
        for (int num : count.keySet()) {
            if (num > k / 2)
                continue;
            
            if (k % 2 == 0 && num == k / 2) {
                res += count.get(num) / 2;
            } else {
                res += Math.min(count.get(num), count.getOrDefault(k - num, 0));
            }
        }
        return res;
    }
}