class Solution {
    public List<String> generateParenthesis(int n) {
        // Add parens from right to left
        // Can only add a right paren if the left paren count is > 0
        // Just keep a count of how many left parens we have, don't need a stack
        // once the length of the string is n * 2 you're done
        List<String> result = new ArrayList<String>();
        dfsFindParens(n, 0, new StringBuilder(), result);
        return result;
    }
    
    public void dfsFindParens(int n, int leftParens, StringBuilder parens, List<String> result)
    {
        // Stop building the string if we are at the maximum number of chars
        if(parens.length() == n * 2) {
            if(leftParens == 0)
                result.add(parens.toString());
            return;
        }

        // Try adding left paren if we can add one, try adding right paren if allowed
        if(parens.length() < ((n * 2) - 1)) 
        {
            parens.append("(");
            dfsFindParens(n, leftParens + 1, parens, result);
            parens.deleteCharAt(parens.length() - 1);
        }
        
        if(leftParens > 0)
        {
            parens.append(")");
            dfsFindParens(n, leftParens - 1, parens, result);
            parens.deleteCharAt(parens.length() - 1);
        }
    }
}