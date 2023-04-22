class Solution {
    
    public int minInsertions(String s) {
        // At each step, add a character in left mirror position or right mirror position
        // How to maintain state? Basically which 2 indexes are we looking at in the original
        // string -> how many chars we had to add to get to this state
        return dfs(s, 0, s.length() - 1, new Integer [s.length()][s.length()]);
    }
    
    public int dfs (String s, int lo, int hi, Integer [][] memo) {        
        if (memo[lo][hi] != null)
            return memo[lo][hi];
        
        // No further additions are necessary, all chars matched
        if (lo >= hi)
            return 0;
        
        // We either can match both of these characters without an addition, match lo with a new addition, or
        // match hi with a new addition. In all three cases we still need to check the remaining
        // characters so the dfs must continue.
        Integer res = null;
        res = (s.charAt(lo) == s.charAt(hi) ?
            dfs(s, lo + 1, hi - 1, memo) + 0 :          // Both characters already match
            Math.min(dfs(s, lo, hi - 1, memo) + 1,      // No match, add character to match with hi
                     dfs(s, lo + 1, hi, memo) + 1));    // No match, add character to match with lo
        
        memo[lo][hi] = res;
        return res;
    }
}