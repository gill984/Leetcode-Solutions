class Solution {
    public int calculateTime(String keyboard, String word) {
        int res = 0;
        char prev = keyboard.charAt(0);
        Map<Character, Integer> charToIndex = new HashMap<>();
        
        for (int i = 0; i < keyboard.length(); i++)
            charToIndex.put(keyboard.charAt(i), i);
        
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(charToIndex.get(prev) - charToIndex.get(word.charAt(i)));
            prev = word.charAt(i);
        }
        
        return res;
    }
}