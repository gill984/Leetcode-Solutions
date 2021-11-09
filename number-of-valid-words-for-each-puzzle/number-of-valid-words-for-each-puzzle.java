class Solution {
    final int SIZE = 26;
    final int PUZZLE_LENGTH = 7;
    
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles)
    {
        // Build a trie of words
        // First sort each word by char and don't include duplicates
        Trie root = new Trie();
        
        for (String w : words)
        {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            StringBuilder unique = new StringBuilder();
            unique.append(chars[0]);
            for (int i = 1; i < chars.length; i++)
                if (chars[i] != chars[i - 1])
                    unique.append(chars[i]);
            
            // Since patterns are at most length 7, any word with more than 7
            // unique characters doesn't need to be considered at all
            if (unique.length() > PUZZLE_LENGTH)
                continue;
            
            // Put this word in the Trie
            root.addWord(unique.toString(), 0);
        }
        
        List<Integer> res = new ArrayList<>();
        for (String p : puzzles)
        {
            res.add(root.search(p, 'a'));
        }
        
        return res;
    }
    
    class Trie
    {
        int count;
        String word;
        Trie [] children;

        public Trie ()
        {
            count = 0;
            word = null;
            children = new Trie[SIZE];
        }

        public void addWord(String word, int idx)
        {
            if (idx == word.length())
            {
                this.count++;
                this.word = word;
            }
            else
            {
                if (children[word.charAt(idx) - 'a'] == null)
                    children[word.charAt(idx) - 'a'] = new Trie();
                children[word.charAt(idx) - 'a'].addWord(word, idx + 1);                
            }
        }
        
        public int search (String p, char start)
        {
            int res = 0;
            if (word != null && word.indexOf(p.charAt(0)) != -1)
                res += count;

            for (char c = start; c <= 'z'; c++)
            {
                if (children[c - 'a'] != null && p.indexOf(c) != -1)
                {
                    res += children[c - 'a'].search(p, (char) (c + 1));
                }
            }
            
            return res;
        }
    }
}