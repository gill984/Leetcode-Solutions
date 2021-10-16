class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // front[i] == score if taking first i cards from front
        // back[i] == score if taking first i cards from back
        int [] front = new int [k + 1];
        int [] back = new int[k + 1];
        
        for (int i = 0; i < k; i++)
        {
            front[i + 1] = front[i] + cardPoints[i];
            back[i + 1] = back[i] + cardPoints[n - 1 - i];
        }
        
        System.out.println(Arrays.toString(front));
        System.out.println(Arrays.toString(back));
        
        int res = 0;
        for (int f = 0; f <= k; f++)
        {
            res = Math.max(res, front[f] + back[k - f]);
        }
        
        return res;
    }
}