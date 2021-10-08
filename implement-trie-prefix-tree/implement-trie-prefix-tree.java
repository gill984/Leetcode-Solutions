class Trie {

    Trie[] children;
    boolean end;
    
    public Trie() {
        children = new Trie[26];
        end = false;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Trie();
            cur = cur.children[c - 'a'];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Trie cur = this;
        for (char c : word.toCharArray())
        {
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
            else
                return false;
        }
        
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray())
        {
            if (cur.children[c - 'a'] != null)
                cur = cur.children[c - 'a'];
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