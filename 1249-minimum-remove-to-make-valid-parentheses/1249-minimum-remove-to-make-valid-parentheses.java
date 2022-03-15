class Solution
{
    public String minRemoveToMakeValid(String s)
    {
        // Remove parentheses from left to right, sum of left parens at the end is 0, return
        // otherwise also remove parentheses from right to left
        StringBuilder buffer = new StringBuilder(s);
        int sum = 0;
        for(int i = 0; i < buffer.length(); i++)
        {
            char c = buffer.charAt(i);
            if(c == '(')
                sum += 1;
            else if(c == ')')
                if(sum > 0)
                    sum -= 1;
                else
                    buffer.deleteCharAt(i--);
        }
        
        if(sum == 0)
            return buffer.toString();
        
        sum = 0;
        for(int i = buffer.length() - 1; i >= 0 && i < buffer.length(); i--)
        {
            char c = buffer.charAt(i);
            if(c == ')')
                sum += 1;
            else if(c == '(')
                if(sum > 0)
                    sum -= 1;
                else
                    buffer.deleteCharAt(i);
        }
        
        return buffer.toString();
    }
}