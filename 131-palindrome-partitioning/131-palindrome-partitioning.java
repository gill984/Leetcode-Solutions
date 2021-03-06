class Solution {
    public List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        
        return res;
    }
    
    public void dfs(String s, int index, List<String> curr, List<List<String>> res)
    {
        if (index >= s.length())
        {
            res.add(new ArrayList<String>(curr));
        }
        
        for (int end = index; end < s.length(); end++)
        {            
            if (checkPalindrome(s, index, end))
            {
                curr.add(s.substring(index, end + 1));
                dfs(s, end + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean checkPalindrome(String s, int start, int end)
    {
        int lo = start;
        int hi = end;
        while (lo < hi)
        {
            if (s.charAt(lo) != s.charAt(hi))
            {
                return false;
            }
            lo++;
            hi--;
        }
        
        return true;
    }
}