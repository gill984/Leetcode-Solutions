class Solution {
    public boolean validPalindrome(String s) {
        return findPalindrome(s, 0, s.length() - 1, false);
    }
    
    public boolean findPalindrome(String s, int lo, int hi, boolean usedDelete) {
        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            }
            else if(!usedDelete) {
                if (findPalindrome(s, lo + 1, hi, true))
                    return true;

                if (findPalindrome(s, lo, hi - 1, true))
                    return true;
                
                return false;
            }
            else
                return false;
        }
        return true;
    }
}