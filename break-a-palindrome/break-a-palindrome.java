class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1)
            return "";
        
        char [] p = palindrome.toCharArray();
        boolean complete = false;
        
        int lo = 0;
        int hi = p.length - 1;
        while (lo < hi)
        {
            if (p[lo] == 'a')
            {
                lo++;
                hi--;
            }
            else
            {
                p[lo] = 'a';
                complete = true;
                break;
            }
        }
        
        // In this case, all letters compared were As
        // make the last one a b
        if (!complete)
        {
            p[p.length - 1] = 'b';
        }
        
        return new String(p);
    }
}