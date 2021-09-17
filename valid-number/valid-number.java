class Solution {
    public boolean isNumber(String s) {
        String [] tokens = s.split("e|E");
        if (tokens.length > 2 || s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'E')
            return false;
        
        return isDecimal(tokens[0]) && (tokens.length == 2 ? isInteger(tokens[1]) : true);
    }
    
    public boolean isDecimal(String ss)
    {
        return isNumber(ss, true);
    }
    
    public boolean isInteger(String ss)
    {
        return isNumber(ss, false);
    }
    
    public boolean isNumber(String ss, boolean decimalAllowed)
    {
        if (ss.length() == 0)
            return false;
        
        char[] s = ss.toCharArray();
        
        // Allowed a sign character at the beginning
        // Need digits to be a decimal
        // Only allowed 1 decimal point
        // Character besides these aren't allowed
        boolean foundDecimal = false;
        boolean foundDigits = false;
        for (int i = 0; i < s.length; i++)
        {
            char c = s[i];
            if (i == 0 && (s[i] == '+' || s[i] == '-'))
            {
                continue;
            }
            else if (decimalAllowed && c == '.')
            {
                if (!foundDecimal)
                    foundDecimal = true;
                else
                    return false;           // found second decimal
            }
            else if (c < '0' || c > '9')
            {
                return false;
            }
            else
            {
                foundDigits = true;
            }
        }
        
        return foundDigits;
    }
}