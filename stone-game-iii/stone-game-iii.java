class Solution {
    int n;
    int [] presum;
    int[] stoneValue;
    Map<Integer, Integer> memo = new HashMap<>();
    
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        this.stoneValue = stoneValue;
        presum = new int [n];
        for (int i = n - 2; i >= 0; i--)
            presum[i] = presum[i] + presum[i + 1];
        
        int alice = dfs(0);
        if (alice > 0)
            return "Alice";
        else if (alice == 0)
            return "Tie";
        else
            return "Bob";
    }
    
    public int dfs(int stone)
    {
        if (memo.containsKey(stone))
            return memo.get(stone);
        else if (stone >= n)            // No stones left
            return 0;
        
        int sum = stoneValue[stone];
        int value = sum - dfs(stone + 1);
        
        for (int take = stone + 1; take < Math.min(stone + 3, n); take++)
        {
            sum += stoneValue[take];
            value = Math.max(value, sum - dfs(take + 1));
        }
        
        memo.put(stone, value);
        return value;
    }
}