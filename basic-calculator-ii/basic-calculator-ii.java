class Solution {
    public int calculate(String ss) {
        // No negative numbers
        // operators delimit the string
        // no parentheses
        // if a * or / is found, can immediately evaluate, save off + or - ops
        char [] s = ss.toCharArray();
        Stack<Integer> terms = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        boolean divide = false;
        boolean multiply = false;
        
        for (int i = 0; i < s.length;)
        {
            if (s[i] == ' ')
            {
                i++;
            }
            else if (Character.isDigit(s[i]))
            {
                int term = 0;
                while (i < s.length && Character.isDigit(s[i]))
                {
                    term = (term * 10) + (s[i] - '0');
                    i++;
                }
                
                if (divide)
                {
                    terms.push(terms.pop() / term);
                    divide = false;
                }
                else if (multiply)
                {
                    terms.push(terms.pop() * term);
                    multiply = false;
                }
                else
                {
                    terms.add(term);
                }
            }
            else if (s[i] == '*')
            {
                multiply = true;
                i++;
            }
            else if (s[i] == '/')
            {
                divide = true;
                i++;
            }
            else if (s[i] == '+' || s[i] == '-')
            {
                ops.add(s[i]);
                i++;
            }
        }
        
        // System.out.println(terms);
        // System.out.println(ops);
        
        int res = terms.get(0);
        for (int i = 1; i < terms.size(); i++)
        {
            char op = ops.get(i - 1);
            if (op == '+')
            {
                res += terms.get(i);
            }
            else if (op == '-')
            {
                res -= terms.get(i);
            }
        }
        
        return res;
    }
}