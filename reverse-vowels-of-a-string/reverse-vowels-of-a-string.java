class Solution {
    public String reverseVowels(String s) {
        char [] sChars = s.toCharArray();
        int lo = 0;
        int hi = s.length() - 1;
        
        while (lo < hi)
        {
            while (lo < sChars.length && lo < hi && !isVowel(sChars[lo]))
                lo++;
            while (hi >= 0 && lo < hi && !isVowel(sChars[hi]))
                hi--;
            
            if (lo < sChars.length && lo < hi && hi >= 0)
            {
                // XOR swap
                // sChars[lo] ^= sChars[hi];
                // sChars[hi] ^= sChars[lo];
                // sChars[lo] ^= sChars[hi];
                char temp = sChars[lo];
                sChars[lo] = sChars[hi];
                sChars[hi] = temp;
            }
            
            lo++;
            hi--;
        }
        
        return new String(sChars);
    }
    
    public boolean isVowel(char c)
    {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
}