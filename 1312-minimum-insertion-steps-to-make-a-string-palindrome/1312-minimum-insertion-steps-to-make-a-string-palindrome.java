class Solution {
    
    public int minInsertions(String s) {
        return dfs(s, 0, s.length() - 1, new Integer [s.length()][s.length()]);
    }
    
    // Return the number of additions necessary to match all characters between
    // lo and hi in s inclusive. Memoize on these lo and hi indexes.
    public int dfs (String s, int lo, int hi, Integer [][] memo) {        
        if (memo[lo][hi] != null)
            return memo[lo][hi];
        
        // No further additions are necessary, all chars matched
        if (lo >= hi)
            return 0;
        
        // We either can match both of these characters without an addition, match lo with a new addition, or
        // match hi with a new addition. In all three cases we still need to check the remaining
        // characters so the dfs must continue.
        memo[lo][hi] = (s.charAt(lo) == s.charAt(hi) ?
            dfs(s, lo + 1, hi - 1, memo) :          // Both characters already match
            Math.min(dfs(s, lo, hi - 1, memo) + 1,      // No match, add character to match with hi
                     dfs(s, lo + 1, hi, memo) + 1));    // No match, add character to match with lo
        
        return memo[lo][hi];
    }
}