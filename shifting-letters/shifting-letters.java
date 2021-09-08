class Solution {
    public String shiftingLetters(String ss, int[] shifts) {
        int shift = 0;
        char[] s = ss.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--)
        {
            shift = ((shift % 26) + (shifts[i] % 26)) % 26;
            s[i] = shiftChar(s[i], shift);
        }
        
        return new String(s);
    }
    
    public char shiftChar(char c, int s)
    {
        return (char) ((((c - 'a') + s) % 26) + (int) 'a');
    }
}