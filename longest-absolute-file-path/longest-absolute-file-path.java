class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> lengthStack = new Stack<>();
        lengthStack.push(0);
        
        int depth = 0;
        int tabs = 0;
        int tempPath = 0;
        char [] s = input.toCharArray();
        boolean file = false;
        int res = 0;
        
        for (int i = 0; i < s.length; i++)
        {
            // System.out.println(lengthStack);
            char c = s[i];
            
            if (c == '\t')
                tabs++;
            else if (c == '.')
            {
                tempPath += 1;
                file = true;
            }
            else if (c == '\n' || i == s.length - 1)
            {
                if (c != '\n')
                    tempPath += 1;
                
                if (file)
                {
                    res = Math.max(tempPath + lengthStack.peek(), res);
                }
                else
                {
                    lengthStack.push(tempPath + 1 + lengthStack.peek());
                    depth += 1;
                }
                
                tempPath = 0;
                tabs = 0;
                file = false;
            }
            else
            {
                while (depth > tabs)
                {
                    depth--;
                    lengthStack.pop();
                }
                
                tempPath += 1;
            }
        }
        
        return res;
    }
}