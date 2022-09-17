class Solution
{    
    public List<List<Integer>> palindromePairs(String[] words)
    {
        // return all indices which when combined, form a palindrome
        // Is the operation commutative? NO
        //     race + car = racecar
        //     car + race = carrace  XXX
        //     car + rac = carrac
        //     rac + car = raccar
        //     car + rrrac = carrrrac
        //     rrrac + car = rrraccar XXX
        //     rrraa + rrr = rrraarrr
        // Note: Words are unique
        
        /*
         * Naive algorithm
         * Combine each word O(n^2)
         *     Test each combination for being a palindrome O(length of word = m)
         *
         * O(n^2 * m)
         */
        List<List<Integer>> res;
        res = new ArrayList<List<Integer>>();
         
        // Build a trie of all words in reverse order
        TrieNode root = buildTrie(words);
        
        // Iterate through the list of words and for each word
        for(int w = 0; w < words.length; w++)
        {
            // Restart each iteration at the root of the trie
            TrieNode iter = root;
            String word = words[w];
            HashSet<Integer> pairIndexes = new HashSet<Integer>();
            
            // Navigate down the trie by matching each next node's character with the current word's current character
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                int idx = c - 'a';
                
                // If the valid character is not present: Stop searching and break
                if(iter.children[idx] == null)
                {
                    break;
                }
                
                iter = iter.children[idx];
                
                // If an "end" marker is hit,
                // check to see if the remaining characters in this word form a palindrome
                // if yes then this is a palindrome
                // Do not count duplicate indices
                if(iter.wordsIndex != TrieNode.NOT_END && (i == word.length() - 1 || isPalindrome(word.substring(i + 1))))
                {
                    pairIndexes.add(iter.wordsIndex);
                }
                
                // If the end of the current word is reached
                // Perform dfs to check if the sub-tries from this stopping point are also palindromes
                // Each sub-trie which is also a palindrome forms a separate larger palindrome
                // Consider hashing any palindromes which are found so they can be looked up in the future
                if(i == word.length() - 1)
                {
                    dfsPalindromes(iter, "", pairIndexes);
                }
            }
            
            // Special case if strings contains empty string
            if(words[w].equals(""))
            {
                for(int i = 0; i < words.length; i++)
                {
                    if(i == w)
                        continue;
                    
                    if(isPalindrome(words[i]))
                    {
                        addToList(res, w, i);
                        addToList(res, i, w);
                    }
                }
            }
            
            for(int x : pairIndexes)
            {
                if(w != x)
                    addToList(res, w, x);
            }
        }
        
        return res;
   }
                   
    
    public void addToList(List<List<Integer>> res, int w, int i)
    {
        List<Integer> l = new ArrayList<Integer>();
        l.add(w);
        l.add(i);
        res.add(l);
    }
    
    // Hashset used as output parameter
    public void dfsPalindromes(TrieNode iter, String subTrieString, HashSet<Integer> subTriePalindromes)
    {
        // System.out.println("Performing dfs search");
        // System.out.println("SubTrieString: " + subTrieString);
        // System.out.println("subTriePalindromes: " + subTriePalindromes);
        
        // From the passed in trienode, find all palindromes        
        // If we're at a leaf node of the trie, see if this is a palindrome
        // If we're not at a leaf node, continue searching each child
        if(iter.wordsIndex != TrieNode.NOT_END && isPalindrome(subTrieString))
        {
            // System.out.println("Words Index: " + iter.wordsIndex);
            // System.out.println("Current Letter: " + iter.letter);
            subTriePalindromes.add(iter.wordsIndex);
        }
        
        // System.out.println(iter.childIndexes);
        for(int childIndex : iter.childIndexes)
        {
            // System.out.println("Adding childIndex: " + childIndex);
            dfsPalindromes(iter.children[childIndex], subTrieString + iter.children[childIndex].letter, subTriePalindromes);
        }
    }
    
    public boolean isPalindrome(String s)
    {
        // System.out.println("Checking if " + s + " is a palindrome.");
        int lo = 0;
        int hi = s.length() - 1;
        while(lo < hi)
        {
            if(s.charAt(lo) != s.charAt(hi))
            {
                // System.out.println("NO");
                return false;
            }
            
            lo++;
            hi--;
        }
        
        // System.out.println("YES");
        return true;
    }
    
    // Build trie of reverse order words and return the root
    public TrieNode buildTrie(String[] words)
    {
        
        // Base case is trie with purposefully invalid character
        TrieNode root = new TrieNode(TrieNode.ROOT_CHAR);
        
        for(int w = 0; w < words.length; w++)
        {
            TrieNode iter = root;
            
            for(int i = words[w].length() - 1; i >= 0; i--)
            {
                char c = words[w].charAt(i);
                
                
                iter = iter.addChild(c);
                
                // i == 0 if this is the end of the word
                if(i == 0)
                {
                    iter.wordsIndex = w;
                }
            }
        }
        
        return root;
    }
}

class TrieNode
{
    // Assume only lower case characters are allowed, if not update code later
    final public static int NUM_LETTERS = 26;
    final public static char ROOT_CHAR = ' ';
    final public static int NOT_END = -1;
    
    public TrieNode [] children = new TrieNode[NUM_LETTERS];   // map to all children
    public char letter;                                        // letter represented by this node
    public int wordsIndex;                                     // -1 if not end of word, index into words if this is the end of that word
    public ArrayList<Integer> childIndexes;
    
    public TrieNode(char l)
    {
        this.letter = l;
        wordsIndex = NOT_END;
        childIndexes = new ArrayList<Integer>();
    }
    
    // Add a child trienode and return this trienode
    // If the child already exists, the end variable is updated if needed
    // and the child is still returned
    public TrieNode addChild(char c)
    {
        int idx = c - 'a';
        
        if(this.children[idx] == null)
        {
            this.children[idx] = new TrieNode(c);
            this.childIndexes.add(c - 'a');
        }
        
        return this.children[idx];
    }
}