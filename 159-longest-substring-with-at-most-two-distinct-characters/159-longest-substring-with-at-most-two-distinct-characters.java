class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String ss) {
        char first = '0';
        char second = '0';
        int lastSwap = 0;
        
        char [] s = ss.toCharArray();
        int lo = 0;
        int hi = 0;
        int res = 0;
        
        while (hi < s.length)
        {
            // System.out.println("HI: " + hi);
            // System.out.println("LO: " + lo);
            // System.out.println("First: " + first);
            // System.out.println("Second: " + second);
            if (s[hi] == first || s[hi] == second)
            {
                if (s[hi] != s[lastSwap])
                {
                    lastSwap = hi;
                }
                
                hi++;
            }
            else if (first == '0')
            {
                lastSwap = hi;
                first = s[hi];
                hi++;
            }
            else if (second == '0')
            {
                lastSwap = hi;
                second = s[hi];
                hi++;
            }
            else
            {
                lo = lastSwap;
                first = s[lo];
                second = s[hi];
                lastSwap = hi;
                hi++;
            }
            
            res = Math.max(res, hi - lo);
        }
        
        return res;
    }
}