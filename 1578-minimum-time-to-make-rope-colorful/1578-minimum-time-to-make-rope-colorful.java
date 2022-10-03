class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char prevColor = '0';
        int maxCost = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = colors.charAt(i);
            if (prevColor == c) {
                res += Math.min(maxCost, neededTime[i]);
                maxCost = Math.max(maxCost, neededTime[i]);
            } else {
                prevColor = c;
                maxCost = neededTime[i];
            }
        }
        
        return res;
    }
}