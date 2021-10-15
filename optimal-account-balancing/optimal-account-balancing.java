class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();
        for (int[] t : transactions)
        {
            balanceMap.put(t[0], balanceMap.getOrDefault(t[0], 0) - t[2]);
            balanceMap.put(t[1], balanceMap.getOrDefault(t[1], 0) + t[2]);
        }
        
        List<Integer> balances = new ArrayList<>();
        for (int k : balanceMap.keySet())
            if (balanceMap.get(k) != 0)
                balances.add(balanceMap.get(k));
        
        int res = dfs(balances, 0);
        return res;
    }
    
    public int dfs (List<Integer> balances, int index)
    {
        while (index < balances.size() && balances.get(index) == 0)
            index++;
        
        int res = Integer.MAX_VALUE;
        for (int j = index + 1, prev = 0; j < balances.size(); j++)
        {
            if (balances.get(j) != prev && balances.get(index) * balances.get(j) < 0)
            {
                balances.set(j, balances.get(j) + balances.get(index));
                res = Math.min(res, 1 + dfs(balances, index + 1));
                balances.set(j, balances.get(j) - balances.get(index));
                prev = balances.get(j);
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}