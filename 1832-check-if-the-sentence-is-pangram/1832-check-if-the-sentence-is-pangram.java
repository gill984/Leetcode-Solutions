class Solution {
    public boolean checkIfPangram(String sentence) {
        int [] count = new int [26];
        for (char c : sentence.toCharArray()) {
            count[c - 'a'] += 1;
        }
        
        for (int i = 0; i < 26; i++)
            if (count[i] == 0)
                return false;
        return true;
    }
}