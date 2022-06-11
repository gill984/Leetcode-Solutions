class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> leftSumToCount = new HashMap<>();
        Map<Integer, Integer> rightSumToCount = new HashMap<>();
        int leftSum = 0, rightSum = 0;
        
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            leftSumToCount.put(leftSum, i + 1);
            rightSum = rightSum + nums[n - 1 - i];
            rightSumToCount.put(rightSum, i + 1);
        }
        
        int res = Math.min(leftSumToCount.getOrDefault(x, Integer.MAX_VALUE),
                           rightSumToCount.getOrDefault(x, Integer.MAX_VALUE));
        
        for (int l : leftSumToCount.keySet()) {
            if (rightSumToCount.containsKey(x - l)) {
                int lCount = leftSumToCount.get(l);
                int rCount = rightSumToCount.get(x - l);
                if (lCount + rCount <= n) {
                    res = Math.min(res, lCount + rCount);
                }
            }
        }
        
        
        // System.out.println((leftSumToCount));
        // System.out.println((rightSumToCount));
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}