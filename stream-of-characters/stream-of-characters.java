class StreamChecker {
    Deque<Character> stream = new ArrayDeque<>();
    int capacity;
    Trie root;

    public StreamChecker(String[] words)
    {
        root = new Trie('0');
        capacity = 0;
        
        // Build an updside down trie
        for (String word : words)
        {
            capacity = Math.max(capacity, word.length());
            Trie curr = root;
            for (int i = word.length() - 1; i >= 0; i--)
            {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Trie(c);

                curr = curr.children[c - 'a'];
                
                if (i == 0)
                    curr.wordStart = true;
            }
        }
    }
    
    public boolean query(char letter)
    {
        stream.addFirst(letter);
        if (stream.size() > capacity)
            stream.removeLast();
        
        Trie curr = root;
        for (char c : stream)
        {
            if (curr.children[c - 'a'] == null)
                return false;
            else
                curr = curr.children[c - 'a'];
            
            if (curr.wordStart)
                return true;
        }
        
        return false;
    }
    
    class Trie
    {
        Trie [] children;
        char c;
        boolean wordStart;
        
        public Trie(char c)
        {
            this.c = c;
            children = new Trie[26];
            wordStart = false;
        }
    }
}