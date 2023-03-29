class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0;
        int n = satisfaction.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i, time = 1; j < n; j++, time++)
                sum += (time * satisfaction[j]);
            res = Math.max(res, sum);
        }
        
        return res;
    }
}