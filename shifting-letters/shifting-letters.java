class Solution {
    public String shiftingLetters(String ss, int[] shifts) {
        int shift = 0;
        char[] s = ss.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--)
        {
            shift = (shift + shifts[i]) % 26;
            s[i] = (char) ((s[i] - 'a' + shift) % 26);
            s[i] += 'a';
        }
        
        return new String(s);
    }
}