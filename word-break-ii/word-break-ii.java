class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> buckets = new HashMap<>();
        for (String w : wordDict)
        {
            buckets.putIfAbsent(w.charAt(0), new ArrayList<>());
            buckets.get(w.charAt(0)).add(w);
        }
        
        List<String> res = new ArrayList<String>();
        search(s, new StringBuilder(), 0, buckets, res);
        return res;
    }
    
    public void search(String s, StringBuilder sentence, int index, Map<Character, List<String>> buckets, List<String> res) {
        if (index == s.length()) {
            res.add(sentence.toString());
            return;
        }
        
        if (!buckets.containsKey(s.charAt(index)))
            return;
        
        List<String> words = buckets.get(s.charAt(index));
            
        for(String word : words) {
            if (word.length() + index <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                int prevLength = sentence.length();
                if (prevLength == 0) {
                    sentence.append(word);
                }
                else {
                    sentence.append(" " + word);
                }
                
                search(s, sentence, index + word.length(), buckets, res);
                sentence.delete(prevLength, sentence.length());
            }
        }
    }
}