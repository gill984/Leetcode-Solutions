class Solution {
    public int strStr(String haystack, String needle)
    {
        if(needle == null || needle.equals(""))
            return 0;
        
        for(int i = 0; i < haystack.length(); i++)
        {
            if(isNeedle(i, haystack, needle))
                return i;
        }
        
        return -1;
    }
    
    public boolean isNeedle(int start, String haystack, String needle)
    {
        int n = 0;
        for(int h = start;h < haystack.length(); h++, n++ )
        {
            if(haystack.charAt(h) != needle.charAt(n))
                return false;
            
            if(n == needle.length() - 1)
                return true;
        }
        
        return false;
    }
}