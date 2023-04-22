class Solution {
    
    public int minInsertions(String s) {
        // At each step, add a character in left mirror position or right mirror position
        // How to maintain state? Basically which 2 indexes are we looking at in the original
        // string -> how many chars we had to add to get to this state
        Integer [][] memo = new Integer [s.length()][s.length()];
        
        int lo = 0;
        int hi = s.length() - 1;
        
        return dfs(s, lo, hi, memo);
    }
    
    public int dfs (String s, int lo, int hi, Integer [][] memo) {
        char charLo = s.charAt(lo);
        char charHi = s.charAt(hi);
        
        if (memo[lo][hi] != null) {
            return memo[lo][hi];
        }
        
        if (lo >= hi) {
            return 0;
        }
        
        Integer res = null;
        if (charLo == charHi) {
            res = dfs(s, lo + 1, hi - 1, memo);
        } else {
            res = Math.min(dfs(s, lo, hi - 1, memo) + 1, dfs(s, lo + 1, hi, memo) + 1);
        }
        
        memo[lo][hi] = res;
        return res;
    }
}