class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Use a sliding window algorithm
        // Each character gets looked at exactly twice, so it's O(n)
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
            
            System.out.println("lo: " + lo);
            System.out.println("hi: " + hi);
            System.out.println("matched: " + matched);
            
            if (windowCount[index] < pCount[index])
            {
                if (lo == -1)
                    lo = hi + 1;
                
                matched++;
                windowCount[index] += 1;
                
                if (matched == p.length())
                {
                    res.add(lo);
                    windowCount[s.charAt(lo) - 'a'] -= 1;
                    lo++;
                    matched--;
                }
            }
            else if (pCount[index] == 0)
            {
                // This character isn't in p
                // zero out all window counts
                for (int i = 0; i < windowCount.length; i++)
                    windowCount[i] = 0;
                
                matched = 0;
                lo = -1;
            }
            else if (windowCount[index] == pCount[index])
            {
                // In this case we need to increment lo 
                // until we can add this character
                while (lo < hi + 1)
                {
                    int lodx = (int) (s.charAt(lo) - 'a');
                    windowCount[lodx] -= 1;
                    matched -= 1;
                    lo++;
                    
                    if (lodx == index)
                    {
                        break;
                    }
                }
                
                matched += 1;
                windowCount[index] += 1;
            }
            
            hi++;
        }
        
        return res;
    }
}