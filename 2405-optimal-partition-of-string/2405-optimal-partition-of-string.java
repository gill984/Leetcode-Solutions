class Solution {
    public int partitionString(String s) {
        int res = 1;
        int inSubstring = 0;
        for (char c : s.toCharArray()) {
            if ((inSubstring & 1 << c - 'a') > 0) {
                res++;
                inSubstring = 0;
            }
            
            inSubstring |= 1 << (c - 'a');
        }
        
        return res;
    }
}