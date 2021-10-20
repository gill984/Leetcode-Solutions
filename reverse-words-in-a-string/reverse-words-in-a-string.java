class Solution
{
    public String reverseWords(String s)
    {
        s = s.trim();
        String [] tokens = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = tokens.length - 1; i >= 0; i--)
        {
            if(tokens[i].equals(""))
                continue;
            else if (i != tokens.length - 1)
                result.append(" ");
            result.append(tokens[i]);
        }
        
        return result.toString();
    }
}