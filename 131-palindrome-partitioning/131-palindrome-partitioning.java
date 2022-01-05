class Solution {
    public List<List<String>> partition(String s)
    {
        // All characters as individual letters is always an option, sometimes that is the only option
        // Start with all characters individual
        // Try combining 2 indices to see if a palindrome is formed
        // if it is a palindrome try doing the combining on the remaining characters
        Map<String, Boolean> isPalindrome = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res, isPalindrome);
        
        return res;
    }
    
    public void dfs(String s, int index, List<String> curr, List<List<String>> res, Map<String, Boolean> isPalindrome)
    {
        if (index >= s.length())
        {
            res.add(new ArrayList<String>(curr));
        }
        
        for (int end = index; end < s.length(); end++)
        {
            // Check map first
            String key = index + "," + end;
            if (!isPalindrome.containsKey(key))
            {
                isPalindrome.put(key, checkPalindrome(s, index, end));
            }
            
            if (isPalindrome.get(key))
            {
                curr.add(s.substring(index, end + 1));
                dfs(s, end + 1, curr, res, isPalindrome);
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