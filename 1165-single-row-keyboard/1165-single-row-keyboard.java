class Solution {
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        char prev = keyboard.charAt(0);
        int [] charToIndex = new int[128];
        
        for (int i = 0; i < keyboard.length(); i++)
            charToIndex[keyboard.charAt(i)] = i;
        
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(charToIndex[prev] - charToIndex[word.charAt(i)]);
            prev = word.charAt(i);
        }
        
        return res;
    }
}