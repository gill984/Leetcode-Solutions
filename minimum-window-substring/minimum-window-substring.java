class Solution {
    public String minWindow(String ss, String ts) {
        char [] t = ts.toCharArray();
        char [] s = ss.toCharArray();
        int total = t.length;
        Map<Character, Integer> count = new HashMap<>();
        
        for (int i = 0; i < t.length; i++)
            count.put(t[i], count.getOrDefault(t[i], 0) + 1);
        
        int lo = 0;
        int hi = -1;
        int matched = 0;
        String res = "";
        
        while (lo < s.length && hi < s.length)
        {
            while (lo < s.length && !count.containsKey(s[lo]))
                lo++;
            
            // System.out.println("lo: " + lo);
            
            if (hi < lo)
                hi = lo - 1;
            
            
            while (hi < s.length && matched < total)
            {
                hi++;
                // System.out.println("Hi: " + hi);
                if (hi < s.length && count.containsKey(s[hi]))
                {
                    count.put(s[hi], count.get(s[hi]) - 1);
                    if (count.get(s[hi]) >= 0)
                        matched += 1;
                    // System.out.println("count of " + s[hi] + ": " + count.get(s[hi]));
                    // System.out.println("Matched: " + matched);
                }
            }
            
            if (matched == total)
            {
                if (res.equals("") || hi - lo + 1 < res.length())
                    res = new String(s, lo, hi - lo + 1);
                count.put(s[lo], count.get(s[lo]) + 1);
                if (count.get(s[lo]) > 0)
                    matched -= 1;
                lo++;
            }
        }
        
        return res;
    }
}