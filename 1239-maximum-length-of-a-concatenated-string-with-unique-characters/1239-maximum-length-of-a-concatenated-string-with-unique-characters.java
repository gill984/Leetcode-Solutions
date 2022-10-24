class Solution
{
    final int FAIL = -1;
    
    // Key realization here is with 26 lowercase characters we can
    // mark each bit in an integer [0:26) with a 1 if the character
    // exists in this string, 0 otherwise. Then we can accumulate
    // if strings have distinct bits. Try all 2^n possibilities since
    // n is small.
    public int maxLength(List<String> arr)
    {
        int n = arr.size();
        int [] bits = new int [n];
        int [] sizes = new int [n];
        int i = 0;
        for (String ss : arr)
        {
            sizes[i] = ss.length();
            bits[i++] = toBits(ss);
        }
        
        return recurseMaxLength(0, 0, 0, bits, sizes);
    }
    
    // On each function call, we want to try using the string at this index and not using
    // the string at this index
    public int recurseMaxLength(int acc, int index, int length, int [] bits, int[] sizes)
    {
        if (index >= bits.length)
            return length;
        
        int chooseLength = 0;
        if (bits[index] != FAIL && (acc & bits[index]) == 0)
            chooseLength = recurseMaxLength(acc + bits[index], index + 1, length + sizes[index], bits, sizes);
        
        return Math.max(chooseLength, recurseMaxLength(acc, index + 1, length, bits, sizes));
    }
    
    // Get bit translated string, return FAIL if the string has
    // any repeated characters
    public int toBits(String ss)
    {
        int res = 0;
        char [] s = ss.toCharArray();
        for (char c : s)
        {
            int bit = 1 << ((int)c - 'a');
            if ((bit & res) != 0)
                return FAIL;
            else
                res ^= bit;
        }
        
        return res;
    }
}