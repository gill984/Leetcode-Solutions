class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                vowelCount++;
        }
        
        int max = vowelCount;
        
        int lo = 0;
        int hi = k - 1;
        
        while (hi < s.length() - 1) {
            if (isVowel(s.charAt(lo)))
                vowelCount--;
            
            lo++;
            hi++;
            
            if (isVowel(s.charAt(hi)))
                vowelCount++;
            
            max = Math.max(max, vowelCount);
        }
        
        return max;
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';  
    }
}