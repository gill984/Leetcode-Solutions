class Solution {
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        char prev = keyboard.charAt(0);
        int [] charToIndex = new int[26];
        
        for (int i = 0; i < keyboard.length(); i++)
            charToIndex[keyboard.charAt(i) - 'a'] = i;
        
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(charToIndex[prev - 'a'] - charToIndex[word.charAt(i) - 'a']);
            prev = word.charAt(i);
        }
        
        return res;
    }
}