class Solution {
    public String reverseString(char[] str) {
        if(str == null)
            return null;
        
        int lo = 0;
        int hi = str.length - 1;
        
        while(lo < hi)
        {
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            lo++;
            hi--;
        }
        
        return new String(str);
    }
}