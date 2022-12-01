class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                if (i < n / 2) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}