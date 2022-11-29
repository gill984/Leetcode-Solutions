class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return dfs(s, k, 0, s.length() - 1, 0, new Integer [s.length()][s.length()]);
    }
    
    public boolean dfs (String s, int k, int lo, int hi, int numUsed, Integer[][] memo) {
        if (memo[lo][hi] != null) {
            if (memo[lo][hi] <= numUsed)
                return false;
        }
        
        if (numUsed > k)
            return false;
        
        memo[lo][hi] = numUsed;
        
        if (hi <= lo && numUsed <= k)
            return true;
        
        char cLo = s.charAt(lo);
        char cHi = s.charAt(hi);
        boolean neither = false;
        
        if (cLo == cHi) {
            neither = dfs(s, k, lo + 1, hi - 1, numUsed, memo);    
        }
        
        boolean left = dfs(s, k, lo + 1, hi, numUsed + 1, memo);
        boolean right = dfs(s, k, lo, hi - 1, numUsed + 1, memo);
        return left || right || neither;        
    }
}