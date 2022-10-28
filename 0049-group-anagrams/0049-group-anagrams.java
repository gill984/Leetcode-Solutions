class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            char [] word = s.toCharArray();
            Arrays.sort(word);
            String sorted = new String(word);
            anagrams.putIfAbsent(sorted, new ArrayList<>());
            anagrams.get(sorted).add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (List<String> val : anagrams.values())
            res.add(val);
        return res;
    }
}