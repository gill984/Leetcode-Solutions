class Solution {
    public String longestPalindrome(String s) {
        // Try every middle element
        String res = "";
        int n = s.length();
        
        for (int i = 0; i < 2; i++) {
            for (int mid = 0; mid < n; mid++) {
                int length = 0;
                for (int lo = mid, hi = mid + i; lo >= 0 && hi < n; lo--, hi++) {
                    if (s.charAt(lo) != s.charAt(hi))
                        break;
                    
                    length += (lo == hi) ? 1 : 2;
                    
                    if (length > res.length()) {
                        res = s.substring(lo, hi + 1);
                    }
                }
            }
        }
        
        return res;
    }
}