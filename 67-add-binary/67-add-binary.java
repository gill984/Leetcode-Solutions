class Solution {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        char [] res = new char [n];
        char carry = '0';
        int adx = a.length() - 1, bdx = b.length() - 1, rdx = n - 1;
        for (; adx >= 0 && bdx >= 0; adx--, bdx--, rdx--)
        {
            char ca = a.charAt(adx);
            char cb = b.charAt(bdx);
            
            if (ca == '1' && cb == '1')
            {
                res[rdx] = carry;
                carry = '1';
            }
            else if (ca == '1' || cb == '1')
            {
                res[rdx] = (carry == '1' ? '0' : '1');
            }
            else
            {
                res[rdx] = carry;
                carry = '0';
            }
        }
        
        while (adx >= 0)
        {
            char ca = a.charAt(adx);
            
            if (ca == '1')
            {
                res[rdx] = (carry == '1' ? '0' : '1');
            }
            else
            {
                res[rdx] = carry;
                carry = '0';
            }
            
            rdx--;
            adx--;
        }
        
        while (bdx >= 0)
        {
            
            char cb = b.charAt(bdx);
            
            if (cb == '1')
            {
                res[rdx] = (carry == '1' ? '0' : '1');
            }
            else
            {
                res[rdx] = carry;
                carry = '0';
            }
            
            bdx--;
            rdx--;
        }
        
        return (carry == '1' ? "1" : "") + new String(res);
        
    }
}