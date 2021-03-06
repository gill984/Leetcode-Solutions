class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        
        for (char c : s.toCharArray())
        {
            if (c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                    return false;
                if (c == ')' && stack.peek() != '(')
                    return false;
                if (c == ']' && stack.peek() != '[')
                    return false;
                if (c == '}' && stack.peek() != '{')
                    return false;
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}