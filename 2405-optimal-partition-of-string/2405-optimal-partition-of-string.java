class Solution {
    public int partitionString(String s) {
        int res = 1;
        boolean [] inSubstring = new boolean [26];
        for (char c : s.toCharArray()) {
            if (inSubstring[c - 'a']) {
                res++;
                inSubstring = new boolean [26];
            }
            
            inSubstring[c - 'a'] = true;
        }
        
        return res;
    }
}