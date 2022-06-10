class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int [] index = new int [128];
        
        for (int hi = 0, lo = 0; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            if (index[c] != 0)
                lo = Math.max(lo, index[c]);
            index[c] = hi + 1;
            res = Math.max(hi - lo + 1, res);
        }
        
        return res;
    }
}