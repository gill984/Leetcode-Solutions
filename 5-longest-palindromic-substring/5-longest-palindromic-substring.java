class Solution {
    public String longestPalindrome(String s) {
        // Try every middle element, O(n^2)
        String res = "";
        int n = s.length();
        
        for (int oddEven = 0; oddEven < 2; oddEven++)
            for (int mid = 0; mid < n; mid++)
                for (int lo = mid, hi = mid + oddEven; lo >= 0 && hi < n && s.charAt(lo) == s.charAt(hi); lo--, hi++) 
                    if (hi - lo + 1 > res.length())
                        res = s.substring(lo, hi + 1);
        
        return res;
    }
}