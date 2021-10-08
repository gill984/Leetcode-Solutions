class Trie {

    Trie [] children;
    boolean isWord;
    public Set<String> words;
    
    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isWord = false;
        words = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie t = this;
        t.words.add(word);
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            //System.out.println(c);
            int index = c - 'a';
            if(t.children[index] == null)
            {
                //System.out.println("New trie at " + index);
                t.children[index] = new Trie();
            }
            if(i == word.length() - 1)
            {
                t.children[index].isWord = true;
            }
            
            //System.out.println("Setting pointer to " + index);
            t = t.children[index];
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return this.words.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie t = this;
        for(char c : prefix.toCharArray())
        {
            if(t.children[c - 'a'] != null)
                t = t.children[c - 'a'];
            else
                return false;
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */