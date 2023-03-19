class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.add(c, i == word.length() - 1);
        }
    }
    
    public boolean search(String word) {
        return dfsSearchWord(root, word, 0);
    }
    
    public boolean dfsSearchWord(Trie curr, String word, int idx) {
        
        if (curr == null)
            return false;
        
        if (idx == word.length())
            return curr.isEnd;
        
        char c = word.charAt(idx);
        if (c != '.') {
            return dfsSearchWord(curr.children[c - 'a'], word, idx + 1);
        } else {
            for (Trie t : curr.children) {
                if (dfsSearchWord(t, word, idx + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

class Trie {
    boolean isEnd;
    Trie [] children;
    
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public Trie add(char c, boolean isEnd) {
        if (children[c - 'a'] == null)
            children[c - 'a'] = new Trie();
        children[c - 'a'].isEnd |= isEnd;
        return children[c - 'a'];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */