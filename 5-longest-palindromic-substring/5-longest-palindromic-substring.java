class Solution {
    public String longestPalindrome(String s) {
        // Try every middle element
        String res = "";
        int n = s.length();
        
        for (int oddThenEven = 0; oddThenEven < 2; oddThenEven++) {
            for (int mid = 0; mid < n; mid++) {
                for (int lo = mid, hi = mid + oddThenEven; lo >= 0 && hi < n; lo--, hi++) {
                    if (s.charAt(lo) != s.charAt(hi))
                        break;
                    
                    if (hi - lo + 1 > res.length())
                        res = s.substring(lo, hi + 1);
                }
            }
        }
        
        return res;
    }
}