class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int res = 0;
        int n = tokens.length;
        int hi = n - 1;
        int lo = 0;
        
        while (hi >= lo) {
            if (power >= tokens[lo]) {
                power -= tokens[lo];
                score += 1;
                lo++;
            } else if (score > 0) {
                power += tokens[hi];
                score -= 1;
                hi--;
            } else {
                break;
            }
            res = Math.max(res, score);
        }
        
        return res;
    }
}