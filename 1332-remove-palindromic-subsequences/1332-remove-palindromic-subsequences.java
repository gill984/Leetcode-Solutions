class Solution {
    public int removePalindromeSub(String s) {
        // Answer is either 1 or 2
        // 1 if the string is already a substring
        return isSubstring(s) ? 1 : 2;
    }
    
    public boolean isSubstring(String s) {
        for (int lo = 0, hi = s.length() - 1; lo < hi; lo++, hi--) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
        }
        
        return true;
    }
}