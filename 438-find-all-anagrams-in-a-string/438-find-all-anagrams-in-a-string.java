class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Use a sliding window algorithm
        // Each character gets looked at twice at most, so it's O(n)
        int lo = -1;
        int hi = -1;
        
        int [] windowCount = new int [26];
        int [] pCount = new int [26];
        int matched = 0;
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < p.length(); i++)
            pCount[p.charAt(i) - 'a'] += 1;
        
        while (hi + 1 < s.length())
        {
            int index = (int) (s.charAt(hi + 1) - 'a');
            
            if (pCount[index] > 0)
            {
                if (lo == -1)
                    lo = hi + 1;
                
                matched++;
                windowCount[index] += 1;
                
                // Make sure we don't include too many of this character
                // by sliding the window over
                while (windowCount[index] > pCount[index])
                {
                    int lodx = (int) (s.charAt(lo) - 'a');
                    windowCount[lodx] -= 1;
                    matched--;
                    lo++;

                    if (lodx == index)
                        break;
                }
                
                if (matched == p.length())
                {
                    res.add(lo);
                    windowCount[s.charAt(lo) - 'a'] -= 1;
                    lo++;
                    matched--;
                }
            }
            else
            {
                // This character isn't in p
                // zero out all window counts
                for (int i = 0; i < windowCount.length; i++)
                    windowCount[i] = 0;
                
                matched = 0;
                lo = -1;
            }
            
            hi++;
        }
        
        return res;
    }
}