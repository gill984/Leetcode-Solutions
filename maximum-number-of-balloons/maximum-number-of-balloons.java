class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        char[] t = text.toCharArray();
        for (char c : t)
            count[c - 'a']++;
        
        int res = count['b' - 'a'];
        res = Math.min(res, count['a' - 'a']);
        res = Math.min(res, count['l' - 'a'] / 2);
        res = Math.min(res, count['o' - 'a'] / 2);
        res = Math.min(res, count['n' - 'a']);
        return res;
    }
}