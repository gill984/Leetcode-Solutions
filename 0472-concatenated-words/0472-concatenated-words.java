class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Bucket sort words by first char
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            buckets.add(new ArrayList<>());
        for (String word : words)
            buckets.get(word.charAt(0) - 'a').add(word);

        // Build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }

            curr.endWord = word;
        }


        // Traverse trie, try each word as the first traversal
        List<String> res = new ArrayList<>();
        for (String word : words)
            traverse(word, 0, false, root.children[word.charAt(0) - 'a'], buckets, res);

        return res;
    }

    public void traverse(String word, int idx, boolean isConcatenated, TrieNode curr, List<List<String>> buckets, List<String> res) {
        if (curr == null)
            return;

        if (idx != word.length() - 1) {
            traverse(word, idx + 1, isConcatenated, curr.children[word.charAt(idx + 1) - 'a'], buckets, res);
            return;
        }

        if (curr.visited)
            return;

        if (isConcatenated)
            curr.visited = true;

        if(isConcatenated && curr.endWord != null)
            res.add(curr.endWord);

        // Traverse out from here using all possible next first characters
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] == null)
                continue;

            for (String nextWord : buckets.get(i))
                traverse(nextWord, 0, true, curr.children[i], buckets, res);
        }
    }

    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean visited = false;
        String endWord = null;

        public TrieNode() {
        }
    }
}