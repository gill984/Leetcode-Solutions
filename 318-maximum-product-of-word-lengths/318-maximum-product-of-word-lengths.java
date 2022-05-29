class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int [] wordBits = new int [n];
        for (int i = 0; i < n; i++) {
            wordBits[i] = wordToBits(words[i].toCharArray());
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = wordBits[i];
                int b = wordBits[j];
                if ((a | b) == (a ^ b)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
    
    public int wordToBits(char[] word) {
        int res = 0;
        for (char c : word) {
            res |= (1 << (c - 'a'));
        }
        
        return res;
    }
}