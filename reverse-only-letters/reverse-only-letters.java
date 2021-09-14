class Solution {
    public String reverseOnlyLetters(String ss) {
        char[] s = ss.toCharArray();
        int lo = 0;
        int hi = s.length - 1;
        
        while (lo < hi) {
            while (lo < hi && !isLetter(s[lo]))
                lo++;
            while (hi > lo && !isLetter(s[hi]))
                hi--;
            
            if (lo < hi)
            {
                char temp = s[lo];
                s[lo] = s[hi];
                s[hi] = temp;
                lo++;
                hi--;
            }
        }
        
        return new String(s);
    }
    
    public boolean isLetter(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}