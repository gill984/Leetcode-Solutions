class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        
        int n = s1.length();
        Boolean [][][] memo = new Boolean [n][n][n + 1];
        return dfs(s1, s2, 0, 0, n, memo);
    }
    
    public boolean dfs(String s1, String s2, int i, int j, int length, Boolean [][][] memo) {
        if (memo[i][j][length] != null) {
            return memo[i][j][length];
        }
        
        if (length == 1) {
            memo[i][j][length] = s1.charAt(i) == s2.charAt(j);
            return memo[i][j][length];
        }
        
        for (int k = 1; k < length; k++) {
            if (dfs(s1, s2, i, j, k, memo) && dfs(s1, s2, i + k, j + k, length - k, memo)) {
                memo[i][j][length] = true;
                return true;
            }
            
            if (dfs(s1, s2, i, j + length - k, k, memo) && dfs(s1, s2, i + k, j, length - k, memo)) {
                memo[i][j][length] = true;
                return true;
            }
        }
        
        memo[i][j][length] = false;
        return false;
    }
}