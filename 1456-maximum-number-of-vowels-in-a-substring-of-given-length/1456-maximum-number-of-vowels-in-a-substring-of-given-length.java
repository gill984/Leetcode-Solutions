class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++)
            if (isVowel(s.charAt(i)))
                vowelCount++;
        
        int max = vowelCount;
        
        int lo = 1;
        int hi = k;
        
        while (hi < s.length()) {
            if (isVowel(s.charAt(lo - 1)))
                vowelCount--;
            
            if (isVowel(s.charAt(hi)))
                vowelCount++;
            
            max = Math.max(max, vowelCount);
            
            if (max == k)
                return max;
            
            lo++;
            hi++;
        }
        
        return max;
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';  
    }
}