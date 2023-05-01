class Solution {
    public int[][] indexPairs(String text, String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<int[]> resList = new ArrayList<>();
        
        // Build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.isWordEnd = true;
        }
        
        // Traverse trie for each start position in text
        for (int start = 0; start < text.length(); start++) {
            TrieNode curr = root;
            for (int i = 0; i + start < text.length(); i++) {
                char c = text.charAt(i + start);
                if (curr.children[c - 'a'] == null)
                    break;
                curr = curr.children[c - 'a'];
                
                if (curr.isWordEnd) {
                    resList.add(new int [] {start, i + start});
                }
            }
        }
        
        int [][] res = new int [resList.size()][2];
        res = resList.toArray(res);
        return res;
    }
}

class TrieNode {
    TrieNode [] children;
    boolean isWordEnd;
    
    public TrieNode () {
        children = new TrieNode[26];
        isWordEnd = false;
    }
}