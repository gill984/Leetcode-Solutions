class Solution {
    public String[] expand(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '{')
            {
                if (curr.length() > 0)
                    tokens.add(curr.toString());
                
                curr = new StringBuilder();
                List<Character> l = new ArrayList<>();
                while (s.charAt(i) != '}')
                {
                    if (s.charAt(i) == ',')
                        i++;
                    
                    l.add(s.charAt(i));
                    i++;
                }
                Collections.sort(l);
                for (char d : l)
                    curr.append(d);
                tokens.add(curr.toString());
                curr = new StringBuilder();
            }
            else
            {
                curr.append(c);
            }
        }
        
        if (curr.length() != 0)
            tokens.add(curr.toString());
        
        List<String> res = new ArrayList<String>();
        System.out.println(tokens);
        dfs(0, new StringBuilder(), tokens, res);
        return res.toArray(new String[res.size()]);
    }
    
    public void dfs (int idx, StringBuilder curr, List<String> tokens, List<String> res)
    {
        if (idx == tokens.size())
        {
            res.add(curr.toString());
            return;
        }
        
        String token = tokens.get(idx);
        if ('{' == token.charAt(token.length() - 1))
        {
            for (char c : token.toCharArray())
            {
                if (c == '{')
                    continue;
                
                curr.append(c);
                dfs (idx + 1, curr, tokens, res);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
        else
        {
            curr.append(token);
            dfs(idx + 1, curr, tokens, res);
            curr.delete(curr.length() - token.length(), curr.length());
        }
    }
}