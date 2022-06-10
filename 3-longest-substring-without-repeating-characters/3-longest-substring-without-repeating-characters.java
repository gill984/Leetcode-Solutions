class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lo = 0;
        int res = 0;
        boolean [] used = new boolean [256];
        
        for (int hi = 0; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            while (used[c])
                used[s.charAt(lo++)] = false;
            used[c] = true;
            res = Math.max(hi - lo + 1, res);
        }
        
        return res;
    }
}