class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        for (String e : emails)
        {
            res.add(evaluate(e));
        }
        
        return res.size();
    }
    
    public String evaluate(String ss)
    {
        StringBuilder res = new StringBuilder();
        char[] s = ss.toCharArray();
        
        // Up to the @ sign
        int index = 0;
        boolean plus = false;
        while (index < s.length && s[index] != '@')
        {
            if (s[index] == '.')
            {
                // Ignore .
            }
            else if (s[index] == '+')
                plus = true;
            else if (!plus)
                res.append(s[index]);
            index++;
        }
        
        // Handle the remaining characters after the @
        while (index < s.length)
            res.append(s[index++]);
        
        return res.toString();
    }
}