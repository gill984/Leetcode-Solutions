class Solution {
    public String longestPalindrome(String s) {
        // Try every middle element
        boolean odd = true;
        int res = 0;
        int n = s.length();
        int resLo = 0;
        
        for (int i = 0; i < 2; i++) {
            for (int mid = 0; mid < n; mid++) {
                int length = 0;
                int lo = mid;
                int hi = odd ? lo : lo + 1;
                for (;lo >= 0 && hi < n; lo--, hi++) {
                    if (s.charAt(lo) != s.charAt(hi))
                        break;
                    
                    length += (lo == hi) ? 1 : 2;
                    
                    if (length > res) {
                        resLo = lo;
                        res = length;
                    }
                }
            }
            odd = false;
        }
        
        return s.substring(resLo, resLo + res);
    }
}