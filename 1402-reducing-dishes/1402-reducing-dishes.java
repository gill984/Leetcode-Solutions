class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0;
        int n = satisfaction.length;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, calculateSatisfaction(satisfaction, i, satisfaction.length - 1));
        }
        
        return res;
    }
    
    public int calculateSatisfaction(int [] s, int i, int j) {
        int res = 0;
        
        for (int idx = i, time = 1; idx <= j; idx++, time++) {
            res += (time * s[idx]);
        }
        
        return res;
    }
}