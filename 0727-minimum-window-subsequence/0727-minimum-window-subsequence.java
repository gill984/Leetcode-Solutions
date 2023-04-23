class Solution {
    int INVALID = -1;
    
    // memo[i][j] = how many chars more necessary in s1 if we're at
    // char i and we've already matched j characters in s2
    public String minWindow(String s1, String s2) {
        int[][] memo = new int [s1.length() + 1][s2.length() + 1];
        int resLength = Integer.MAX_VALUE;
        String resString = "";
        
        for (int i = 0; i < s1.length(); i++) {
            int length = dfs(s1, s2, memo, i, 0);
            
            if (length == INVALID)
                break;
            
            if (length < resLength) {
                resString = s1.substring(i, i + length);
                resLength = length;
            }
        }
        
        return resString;
    }
    
    public int dfs(String s1, String s2, int [][] memo, int idx1, int idx2) {
        if (memo[idx1][idx2] != 0)
            return memo[idx1][idx2];
        
        if (idx2 >= s2.length())
            return memo[idx1][idx2] = 0;
        
        if (idx1 >= s1.length())
            return memo[idx1][idx2] = INVALID;
        
        int res = dfs(s1, s2, memo, idx1 + 1, idx2 + (s1.charAt(idx1) == s2.charAt(idx2) ? 1 : 0));
        
        if (res == INVALID)
            return memo[idx1][idx2] = INVALID;
        
        return memo[idx1][idx2] = res + 1;
    }
}