class Solution {
    public List<String> letterCombinations(String digits) {
        String [] map = new String[] {"", "", "abc", "def", "ghi", 
                                      "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if (digits != null && digits.length() > 0) {
            dfs (new StringBuilder(), map, digits, 0, res);
        }
        return res;
    }
    
    private void dfs (StringBuilder curr, String[] map, String digits, int idx, List<String> res) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }
        
        for (char c : map[digits.charAt(idx) - '0'].toCharArray()) {
            curr.append(c);
            dfs (curr, map, digits, idx + 1, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}