class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lo = 0;
        int hi = 0;
        int res = 0;
        boolean [] used = new boolean [256];
        
        while (hi < s.length()) {
            char c = s.charAt(hi);
            while (used[c]) {
                used[s.charAt(lo)] = false;
                lo++;
            }
            used[c] = true;
            res = Math.max(hi - lo + 1, res);
            
            hi++;
        }
        
        return res;
    }
}