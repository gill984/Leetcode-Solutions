class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Each word must have the same set of characters
        // the two word's character counts must be the same while ignoring the char values
        Set<Character> chars = new HashSet<>();
        int [] count1 = new int [128];
        int [] count2 = new int [128];
        for (char c : word1.toCharArray()) {
            chars.add(c);
            count1[c]++;
        }
        
        for (char c : word2.toCharArray()) {
            if (!chars.contains(c)) {
                return false;
            }
            count2[c]++;
        }
        
        int [] countCount = new int [100001];
        for (int i : count1) {
            if (i != 0)
                countCount[i] += 1;
        }
        
        for (int i : count2) {
            if (i == 0)
                continue;
            
            if (countCount[i] == 0)
                return false;
            else 
                countCount[i] -= 1;
        }
        
        for (int i : countCount) {
            if (i != 0)
                return false;
        }
        
        return true;
    }
}