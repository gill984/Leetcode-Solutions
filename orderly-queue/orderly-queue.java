class Solution {
    public String orderlyQueue(String ss, int k) {
        char[] s = ss.toCharArray();
        if (k == 1)
        {
            int n = s.length;
            int best = 0;
            for (int begin = 1; begin < s.length; begin++) {
                for (int i = 0; i < s.length; i++) {
                    if (s[(best + i) % n] < s[(begin + i) % n]) break;
                    else if (s[(best + i) % n] > s[(begin + i) % n]) {
                        best = begin;
                        break;
                    }
                }
            }
            
            return ss.substring(best) + ss.substring(0, best);
        }
        
        Arrays.sort(s);
        return new String(s);
    }
}