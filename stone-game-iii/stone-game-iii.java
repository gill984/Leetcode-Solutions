class Solution {
    final int SENTINEL = Integer.MIN_VALUE;
    int n;
    int [] presum;
    int[] stoneValue;
    int[] memo;
    
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        this.stoneValue = stoneValue;
        presum = new int [n];
        memo = new int[n];
        Arrays.fill(memo, SENTINEL);
        for (int i = n - 2; i >= 0; i--)
            presum[i] = presum[i] + presum[i + 1];
        
        int alice = dfs(0);
        if (2 * alice > presum[0])
            return "Alice";
        else if (2 * alice == presum[0])
            return "Tie";
        else
            return "Bob";
    }
    
    public int dfs(int stone)
    {
        if (stone >= n)            // No stones left
            return 0;
        if (memo[stone] != SENTINEL)
            return memo[stone];
        
        
        int res = Integer.MIN_VALUE;
        for (int take = 0; take < 3; take++)
        {
            int one = stoneValue[stone];
            int two = (take > 0 && stone + 1 < n) ? stoneValue[stone + 1] : 0;
            int three = (take > 1 && stone + 2 < n) ? stoneValue[stone + 2] : 0;
            
            int pickup = one + two + three;
            int remainingStones = (stone + take + 1 < n) ? presum[stone + take + 1] : 0;
            res = Math.max(res, pickup + (remainingStones - dfs(stone + take + 1)));
        }
        
        memo[stone] = res;
        return res;
    }
}