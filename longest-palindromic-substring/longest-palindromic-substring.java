class Solution {
    public String longestPalindrome(String ss)
    {
        if(ss == null || ss.length() < 2)
            return ss;
        
        char [] s = ss.toCharArray();
        int [] max = new int [2];
        
        for(int mid = 1; mid < s.length; mid++)
        {
            int[] odd = extend(mid - 1, mid + 1, s);
            int[] even = extend(mid - 1, mid, s);
            if (odd[1] - odd[0] > max[1] - max[0])
                max = odd;
            if (even[1] - even[0] > max[1] - max[0])
                max = even;
        }
        
        return ss.substring(max[0], max[1] + 1);
    }
    
    public int[] extend(int i, int j, char[] s)
    {
        while(i >= 0 && j < s.length && s[i] == s[j])
        {
            i -= 1;
            j += 1;
        }
        
        i++;
        j--;
        
        return new int [] {i, j};
    }
}