class Solution {
    public String decodeString(String s) {
        return decodeStringN(s, 0);
    }
    
    int nextIdx = 0;
    public String decodeStringN(String s, int start)
    {
        StringBuilder res = new StringBuilder();
        int repeat = 0;
        for (int i = start; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
            {
                repeat = repeat * 10 + (c - '0');
            }
            else if (c == '[')
            {
                String d = decodeStringN(s, i + 1);
                for (int j = 0; j < repeat; j++)
                    res.append(d);
                repeat = 0;
                i = nextIdx;
            }
            else if (c == ']')
            {
                nextIdx = i;
                return res.toString();
            }
            else
            {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}