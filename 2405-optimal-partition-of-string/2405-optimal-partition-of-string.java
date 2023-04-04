class Solution {
    public int partitionString(String s) {
        int res = 0;
        boolean [] inSubstring = new boolean [26];
        Arrays.fill(inSubstring, true);
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