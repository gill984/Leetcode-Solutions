class Solution
{
    final int FAIL = -1;
    
    public int maxLength(List<String> arr)
    {
        int n = arr.size();
        int [] bits = new int [n];
        int i = 0;
        for (String ss : arr)
        {
            bits[i] = toBits(ss);
            i++;
        }
        
        System.out.println(Arrays.toString(bits));
        
        return recurseMaxLength(0, 0, 0, bits, arr);
        
    }
    
    public int recurseMaxLength(int acc, int index, int length, int [] bits, List<String> arr)
    {
        if (index >= bits.length)
            return length;
        
        int chooseLength = 0;
        if (bits[index] != FAIL && (acc & bits[index]) == 0)
            chooseLength = recurseMaxLength(acc + bits[index], index + 1, length + arr.get(index).length(), bits, arr);
        
        return Math.max(chooseLength, recurseMaxLength(acc, index + 1, length, bits, arr));
    }
    
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