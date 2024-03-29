class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < word1.length() || idx < word2.length()) {
            res.append(idx < word1.length() ? word1.charAt(idx) : "");
            res.append(idx < word2.length() ? word2.charAt(idx) : "");
            idx++;
        }
        return res.toString();
    }
}