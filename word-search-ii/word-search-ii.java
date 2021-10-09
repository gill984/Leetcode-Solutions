class Solution {
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words)
    {
        int m = board.length;
        int n = board[0].length;
        Trie root = new Trie();
        for (String word : words)
            root.insert(word);
        
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (root.children[board[i][j] - 'a'] != null)
                    dfs(root, board, i, j, new StringBuilder(), res);
        
        return res;
    }
    
    public void dfs (Trie cur, char[][] board, int i, int j, StringBuilder s, List<String> res)
    {
        int m = board.length;
        int n = board[0].length;
        char c = board[i][j];
        
        if (c != '0' && cur.children[c - 'a'] != null)
        {
            cur = cur.children[c - 'a'];
            s.append(c);
            char temp = board[i][j];
            board[i][j] = '0';
            if (cur.isEnd)
            {
                res.add(s.toString());
                cur.isEnd = false;  // Don't add the same word twice
            }
            
            for (int [] dir : dirs)
            {
                int nextRow = i + dir[0];
                int nextCol = j + dir[1];
                
                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n)
                {
                    dfs(cur, board, nextRow, nextCol, s, res);
                }
            }
            
            // Reset board state after dfs returns
            board[i][j] = temp;
            s.deleteCharAt(s.length() - 1);
        }
    }
    
    class Trie
    {
        Trie [] children;
        boolean isEnd;
        
        public Trie()
        {
            children = new Trie[26];
            isEnd = false;
        }
        
        public void insert(String word)
        {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }
    }
}