class Solution {
    public String longestPalindrome(String s) {
        // Try every middle element
        int res = 0;
        int n = s.length();
        int resLo = 0;
        
        for (int i = 0; i < 2; i++) {
            for (int mid = 0; mid < n; mid++) {
                int length = 0;
                for (int lo = mid, hi = mid + i; lo >= 0 && hi < n; lo--, hi++) {
                    if (s.charAt(lo) != s.charAt(hi))
                        break;
                    
                    length += (lo == hi) ? 1 : 2;
                    
                    if (length > res) {
                        resLo = lo;
                        res = length;
                    }
                }
            }
        }
        
        return s.substring(resLo, resLo + res);
    }
}