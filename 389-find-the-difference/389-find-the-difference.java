class Solution {
    public char findTheDifference(String s, String t) {
        int [] count = new int [26];
        for (char c : t.toCharArray())
            count[c - 'a'] += 1;
        
        for (char c : s.toCharArray())
            count[c - 'a'] -= 1;
        
        int i = 0;
        for (; i < count.length; i++) 
            if (count[i] == 1)
                break;
        
        return (char) ('a' + i);
    }
}