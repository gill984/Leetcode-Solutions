class Solution {
    final int TAKE = 0;
    final int LEAVE = 1;
    final int NUM = 2;
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numToScore = new TreeMap<>();
        for (int i : nums)
            numToScore.put(i, numToScore.getOrDefault(i, 0) + i);
        // System.out.println(numToScore);
        
        // Is there a sub-problem we can solve?
        // Keep track of the max score when number i is taken or not taken
        // where i is the current largest value allowed in the solution
        int idx = 0;
        int n = numToScore.size();
        int[][] dp = new int[3][n];
        for (Map.Entry<Integer, Integer> entry : numToScore.entrySet())
        {
            // System.out.println(entry);
            int i = entry.getKey();
            int v = entry.getValue();
            dp[TAKE][idx] = v + 
                Math.max(
                    (idx > 1 ? dp[TAKE][idx - 2] : 0),
                    Math.max(
                    (idx > 0 ? dp[LEAVE][idx - 1] : 0),
                    (idx > 0 && dp[NUM][idx - 1] != i - 1 ? dp[TAKE][idx - 1] : 0)));
            
            dp[LEAVE][idx] = (idx > 0 ? Math.max(dp[LEAVE][idx - 1], dp[TAKE][idx - 1]) : 0);
            dp[NUM][idx] = i;
            idx++;
        }
        
        // System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[TAKE][n - 1], dp[LEAVE][n - 1]);
    }
}