class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int idx = 0;
        
        while (idx < s.length())
        {
            int [] res = eval (s, idx + 1);
            idx = res[1];
            score += res[0];
        }
        
        return score;
    }
    
    public int[] eval (String s, int idx)
    {
        int score = 0;
        while (idx < s.length())
        {
            if (s.charAt(idx) == ')')
            {
                return new int [] {score == 0 ? 1 : score, idx + 1};
            }
            else
            {
                int [] inner = eval(s, idx + 1);
                idx = inner[1];
                score += inner[0] * 2;
            }
        }
        
        return new int [] {score, idx};
    }
}