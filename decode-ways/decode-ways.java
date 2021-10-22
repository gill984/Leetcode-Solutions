class Solution {
    public int numDecodings(String s) {
        return dfs(s.toCharArray(), 0, new HashMap<Integer, Integer>());
    }
    
    public int dfs(char [] s, int index, Map<Integer, Integer> memo)
    {
        if (memo.containsKey(index))
            return memo.get(index);
        
        if (index == s.length)
            return 1;
        
        if (s[index] == '0')
            return 0;
        
        if (index == s.length - 1)
            return 1;
        
        int one = dfs(s, index + 1, memo);
        int two = 0;
        if ((s[index] - '0') * 10 + (s[index + 1] - '0') <= 26)
            two = dfs(s, index + 2, memo);
        memo.put(index, one + two);
        return one + two;
    }
}