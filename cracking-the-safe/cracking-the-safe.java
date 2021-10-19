class Solution {
    int START = 0;
    int MOD;
    int K_TO_THE_N;
    public String crackSafe(int n, int k) {
        StringBuilder res = new StringBuilder();
        Set<Integer> visited = new HashSet<>();
        MOD = 1;
        for (int i = 1; i < n; i++)
            MOD *= 10;
        
        K_TO_THE_N = k;
        for (int i = 1; i < n; i++)
            K_TO_THE_N *= k;
        
        dfs(res, n, k, START, visited);
        return res.toString();
    }
    
    public boolean dfs(StringBuilder res, int n, int k, int cur, Set<Integer> visited)
    {
        // System.out.println(visited);
        if (visited.size() == K_TO_THE_N)
            return true;
        
        // Remove most significant digit from cur and make space for the next digit
        if (res.length() >= n)
        {
            cur = cur % MOD;
            cur *= 10;
        }
        
        for (int digit = 0; digit < k; digit++)
        {
            // If we already visited, this isn't a minimum path
            if(visited.contains(cur + digit))
                continue;
            
            // Try with this new digit
            res.append(digit);
            if (res.length() >= n)
                visited.add(cur + digit);
            if (dfs(res, n, k, cur + digit, visited))
                return true;
            
            // Failed to visit all nodes in length
            res.deleteCharAt(res.length() - 1);
            if (res.length() >= n)
                visited.remove(cur + digit);
        }
        
        return false;
    }
}