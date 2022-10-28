class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            String sorted = createKey(s);
            anagrams.putIfAbsent(sorted, new ArrayList<>());
            anagrams.get(sorted).add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> val : anagrams.values())
            res.add(val);
        return res;
    }
    
    public String createKey(String s) {
        int [] count = new int [26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            res.append(count[i] + ",");
        }
        return res.toString();
    }
}