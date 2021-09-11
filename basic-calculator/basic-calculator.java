class Solution {
    final int NONE = 0;
    final int ADD = 1;
    final int SUB = 2;
    
    final int VAL = 0;
    final int IDX = 1;
    
    boolean PRINT = false;
    
    public int calculate(String s) {
        return evaluate(s, s.toCharArray(), 0)[VAL];
    }
    
    public int[] evaluate(String ss, char[] s, int index)
    {
        int val = 0;
        int state = NONE;
        
        while (index < s.length)
        {
            if(PRINT) System.out.println("At " + index);
            char c = s[index];
            
            // if c is a space, keep going
            if (c == ' ')
            {
                index++;
                continue;
            }
            
            if (Character.isDigit(c))
            {
                int[] valIndex = readInt(ss, s, index);
                if (state == NONE || state == ADD)
                    val += valIndex[0];
                else if (state == SUB)
                    val -= valIndex[0];
                index = valIndex[1];
                state = NONE;
                if(PRINT) System.out.println("Found number: " + (valIndex[0]) + ", updated index to: " + index);
            }
            else if (c == '(')
            {
                if(PRINT) System.out.println("Found (, call to evaluate at " + (index + 1));
                int[] parenRes = evaluate(ss, s, index + 1);
                
                if (state == NONE || state == ADD)
                    val += parenRes[VAL];
                else if (state == SUB)
                    val -= parenRes[VAL];
                
                index = parenRes[IDX];
                state = NONE;
            }
            else if (c == '+')
            {
                if(PRINT) System.out.println("Switching to + state");
                state = ADD;
                index++;
            }
            else if (c == '-')
            {
                if(PRINT) System.out.println("Switching to - state");
                state = SUB;
                index++;
            }
            else if (c == ')')
            {
                if(PRINT) System.out.println("Returning from call to evaluate with val: " + val + ", index: " + (index + 1));
                return new int[] {val, index + 1};
            }
        }
        
        return new int[] {val, index};
    }
    
    public int[] readInt(String ss, char[] s, int start)
    {
        int end = start;
        while (end < s.length && Character.isDigit(s[end]))
            end++;
        
        int val = 0;
        int mult = 1;
        for (int i = end - 1; i >= start; i--)
        {
            int digit = s[i] - '0';
            val += (digit * mult);
            mult *= 10;
        }
        
        return new int[] {val, end};
    }
}