class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += cardPoints[i];
        
        int res = sum;
        
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - 1 - i];
            sum += cardPoints[cardPoints.length - 1 - i];
            res = Math.max(res, sum);
        }
        
        return res;
    }
}