class Solution {
    public int partitionString(String s) {
        if (s == null || s.equals(""))
            return 0;
        
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