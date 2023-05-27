class Solution {
    int n;
    int [] presum;
    Integer [] memo;
    
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        presum = new int [n];
        memo = new Integer [n];
        presum[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            presum[i] = stoneValue[i] + presum[i + 1];
        }
        // System.out.println(Arrays.toString(presum));
        int aliceScore = dfs(stoneValue, 0);
        // System.out.println(aliceScore);
        int diff = presum[0] - aliceScore;
        if (diff == aliceScore)
            return "Tie";
        else
            return aliceScore > diff ? "Alice" : "Bob";
    }
    
    public int dfs (int [] stoneValue, int idx) {
        if (idx == stoneValue.length) {
            return 0;
        }
        
        if (memo[idx] != null) {
            return memo[idx];
        }
        
        int max = -10000;
        int sum = 0;
        for (int i = 0; i < 3 && idx + i < stoneValue.length; i++) {
            sum += stoneValue[idx + i];
            int opponentMax = dfs(stoneValue, idx + i + 1);
            int playerMax = idx + i + 1 < n ? presum[idx + i + 1] - opponentMax : 0;
            max = Math.max(playerMax + sum, max);
        }
        
        memo[idx] = max;
        return max;
    }
}