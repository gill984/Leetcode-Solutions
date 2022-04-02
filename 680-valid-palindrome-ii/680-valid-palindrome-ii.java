class Solution
{
    public boolean validPalindrome(String s)
    {
        // solve palindrome and allow for one mistake
        int n = s.length();
        int lo = 0;
        int hi = n - 1;
        boolean miss = false;
        
        while (!miss && lo < hi)
        {
            if (s.charAt(lo) != s.charAt(hi))
            {
                miss = true;
            }
            else
            {
                lo++;
                hi--;
                // System.out.println("here");
            }
        }
        
        if (!miss)
            return true;
        
        // System.out.println(lo + ", " + hi);
        
        int tempLo = lo;
        int tempHi = hi;
        miss = false;
        // Try lo first, hi later if that doesn't work
        lo++;
        while (!miss && lo < hi)
        {
            if (s.charAt(lo) != s.charAt(hi))
            {
                miss = true;
            }
            else
            {
                lo++;
                hi--;
            }
        }
        
        if (!miss)
            return true;
        
        lo = tempLo;
        hi = tempHi - 1;
        miss = false;
        
        while (!miss && lo < hi)
        {
            if (s.charAt(lo) != s.charAt(hi))
            {
                miss = true;
            }
            else
            {
                lo++;
                hi--;
            }
        }
        
        return !miss;
    }
}