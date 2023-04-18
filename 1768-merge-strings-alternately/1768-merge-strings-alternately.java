class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < word1.length() && idx < word2.length())
            res.append(word1.charAt(idx) + "" + word2.charAt(idx++));
        
        res.append(word1.substring(idx));
        res.append(word2.substring(idx));
        return res.toString();
    }
}