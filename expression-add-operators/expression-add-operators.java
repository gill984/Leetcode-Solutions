class Solution {
    boolean overflow = false;
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        s.append(num.charAt(0));
        dfs(s, num.toCharArray(), 1, res, s.charAt(0) != '0');
        Iterator<String> it = res.iterator();
        while (it.hasNext())
        {
            String out = it.next();
            if (evaluate(out) != target || overflow)
                it.remove();
            overflow = false;
        }
        
        return res;
    }
    
    public int evaluate(String expression)
    {
        char [] e = expression.toCharArray();
        
        List<Long> terms = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        // Break up terms and operations between terms
        for (int i = 0; i < e.length; i++)
        {
            if (Character.isDigit(e[i]))
            {
                long num = 0;
                while (i < e.length && Character.isDigit(e[i]))
                    num = num * 10 + (e[i++] - '0');
                i--;
                terms.add(num);
            }
            else
                ops.add(e[i]);
        }
        
        // Evaluate multiplication
        for (int i = 0; i < ops.size(); i++)
        {
            if (ops.get(i) == '*')
            {
                // System.out.println();
                // System.out.println(terms);
                // System.out.println(ops);
                terms.set(i, terms.get(i) * terms.get(i + 1));
                terms.remove(i + 1);
                ops.remove(i);
                // System.out.println(terms);
                // System.out.println(ops);
                i--;
            }
        }
        
        // Evaluate addition and subtraction
        long res = terms.get(0);
        for (int i = 0; i < ops.size(); i++)
        {
            if (ops.get(i) == '+')
                res += terms.get(i + 1);
            else
                res -= terms.get(i + 1);
        }
        
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            overflow = true;
        
        return (int) res;
    }
    
    public void dfs(StringBuilder s, char[] num, int index, List<String> res, boolean allowConcatenation)
    {
        if (index == num.length)
            res.add(s.toString());
        else
        {
            int n = num[index] - '0';
            
            // Concatenate
            if (allowConcatenation)
            {
                s.append(n);
                dfs(s, num, index + 1, res, true);
                s.delete(s.length() - 1, s.length());
            }
            
            // Add
            s.append("+" + n);
            dfs(s, num, index + 1, res, n != 0);
            s.delete(s.length() - 2, s.length());
            
            // Subtract
            s.append("-" + n);
            dfs(s, num, index + 1, res, n != 0);
            s.delete(s.length() - 2, s.length());
            
            // Multiply
            s.append("*" + n);
            dfs(s, num, index + 1, res, n != 0);
            s.delete(s.length() - 2, s.length());
        }
    }
}