class Solution {
    final int NONE = 0;
    final int ADD = 1;
    final int SUB = 2;
    
    final int VAL = 0;
    final int IDX = 1;
    
    public int calculate(String s) {
        return evaluate(s.toCharArray(), 0)[VAL];
    }
    
    public int[] evaluate(char[] s, int index) {
        int val = 0;
        int state = NONE;
        
        while (index < s.length) {
            char c = s[index];
            
            if (c >= '0' && c <= '9' || c == '(') {
                int[] valIndex;
                if (c == '(')
                    valIndex = evaluate(s, index + 1);
                else
                    valIndex = readInt(s, index);
                
                if (state == NONE || state == ADD)
                    val += valIndex[VAL];
                else if (state == SUB)
                    val -= valIndex[VAL];
                index = valIndex[IDX];
                state = NONE;
            }
            else if (c == '+')
                state = ADD;
            else if (c == '-')
                state = SUB;
            else if (c == ')')
                return new int[] {val, index};
            
            index++;
        }
        
        return new int[] {val, index};
    }
    
    public int[] readInt(char[] s, int start) {
        int end = start;
        int val = 0;
        while (end < s.length && s[end] >= '0' && s[end] <= '9')
            val = (10 * val) + (s[end++] - '0');
        
        return new int[] {val, end - 1};
    }
}