class Solution {
    public String reverseVowels(String s) {
        char [] sChars = s.toCharArray();
        int lo = 0;
        int hi = s.length() - 1;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        while (lo < hi)
        {
            while (lo < sChars.length && lo < hi && !vowels.contains(sChars[lo]))
                lo++;
            while (hi >= 0 && lo < hi && !vowels.contains(sChars[hi]))
                hi--;
            
            if (lo < sChars.length && lo < hi && hi >= 0)
            {
                // XOR swap
                sChars[lo] ^= sChars[hi];
                sChars[hi] ^= sChars[lo];
                sChars[lo] ^= sChars[hi];
            }
            
            lo++;
            hi--;
        }
        
        return new String(sChars);
    }
}