class Solution {
    public String minWindow(String s1, String s2) {
        // memo[i][j] = how many chars more necessary in s1 if we're at
        // char i and we've already matched j characters in s2
        int[][] memo = new int [s1.length() + 1][s2.length() + 1];
        
        int res = Integer.MAX_VALUE;
        String stringRes = "";
        for (int i = 0; i < s1.length(); i++) {
            int step = dfs(s1, s2, memo, i, 0);
            if (step == -1)
                continue;
            if (step < res) {
                // System.out.println(step);
                stringRes = s1.substring(i, i + step);
                res = step;
            }
        }
        
        return stringRes;
    }
    
    public int dfs(String s1, String s2, int [][] memo, int idx1, int idx2) {
        if (memo[idx1][idx2] != 0) {
            return memo[idx1][idx2];
        }
        
        if (idx2 >= s2.length()) {
            return memo[idx1][idx2] = 0;
        }
        
        if (idx1 >= s1.length()) {
            return memo[idx1][idx2] = -1;
        }
        
        char c1 = s1.charAt(idx1);
        char c2 = s2.charAt(idx2);
        
        int res = 0;
        if (c1 == c2) {
            res = dfs(s1, s2, memo, idx1 + 1, idx2 + 1);
        } else {
            res = dfs(s1, s2, memo, idx1 + 1, idx2);
        }
        
        if (res == -1) {
            return memo[idx1][idx2] = -1;
        } else {
            return memo[idx1][idx2] = res + 1;
        }
    }
}