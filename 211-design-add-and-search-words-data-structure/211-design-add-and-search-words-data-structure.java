class WordDictionary {
    Trie root;
    
    public WordDictionary() {
        root = new Trie('0');
    }
    
    public void addWord(String word) {
        root.insert(word);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    class Trie
    {
        Trie[] children;
        char c;
        boolean isWord;
        
        public Trie (char c)
        {
            children = new Trie [26];
            this.c = c;
            isWord = false;
        }
        
        public void insert(String word)
        {
            Trie curr = this;
            
            for (char c : word.toCharArray())
            {
                if (curr.children[c - 'a'] == null)
                {
                    curr.children[c - 'a'] = new Trie(c);
                }
                curr = curr.children[c - 'a'];
            }
            
            curr.isWord = true;
        }
        
        public boolean search(String pattern, int idx)
        {
            Trie curr = this;
            if (curr.isWord && idx == pattern.length())
            {
                return true;
            }
            
            if (idx >= pattern.length())
            {
                return false;
            }
            
            char c = pattern.charAt(idx);
            if (c == '.')
            {
                // Try all paths for this particular character
                for (int j = 0; j < curr.children.length; j++)
                {
                    if (curr.children[j] == null)
                    {
                        continue;
                    }
                    else if (curr.children[j].search(pattern, idx + 1))
                    {
                        return true;
                    }
                }

                return false;
            }
            else
            {
                if (curr.children[c - 'a'] == null)
                    return false;
                else
                    return curr.children[c - 'a'].search(pattern, idx + 1);
            }
        }
    }
}