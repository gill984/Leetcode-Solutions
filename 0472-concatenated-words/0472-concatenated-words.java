class Solution {
    Map<String, Boolean> memo;
    Set<String> wordSet;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 1)
            return result;
        
        wordSet = new HashSet<String>();
        memo = new HashMap<String, Boolean>();
        
        for(String word : words)
            wordSet.add(word);
        
        for(String word : words)
            if(recurseDivide(word) && !word.equals("") )
                result.add(word);
        
        return result;
    }
    
    public boolean recurseDivide(String s)
    {
        if(s == null || s.length() == 0)
            return false;
        
        // If we already searched this string
        if (memo.containsKey(s))
            return memo.get(s);
            
        for(int l = 1; l < s.length(); l++)
        {
            String left = s.substring(0, l);
            String right = s.substring(l, s.length());
            if(wordSet.contains(left) && (wordSet.contains(right) || recurseDivide(right)))
            {
                memo.put(s, true);
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
    }
}