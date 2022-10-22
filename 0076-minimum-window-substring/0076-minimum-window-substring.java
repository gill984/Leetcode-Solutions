class Solution {
    public String minWindow(String s, String t) {
        // Naive solution, from each character in s, iterate until character counts in t is 0. O(n^2)
        // When moving to the next character x in s, if x-1 is in t, then the right side will need to expand,
        // if not in t then this is the optimal window starting at x
        // As result store starting idx and length
        int hi = 0;
        int resIdx = -1;
        int resHi = 1000000;
        
        int tCount = 0;                         // how many characters we haven't matched yet in t
        int [] count = new int [128];           // count of each ascii character in t
        Set<Character> inT = new HashSet<>();   // contains all characters in t
        for (char c : t.toCharArray()) {
            count[c] += 1;
            tCount += 1;
            inT.add(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            // Remove the first character of the previous try
            if (i > 0) {
                char prevS = s.charAt(i - 1);
                if (inT.contains(prevS)) {
                    count[prevS] += 1;
                    if (count[prevS] > 0) {
                        tCount += 1;
                    }
                }
            }
            
            
            // Add necessary characters until tCount == 0
            while (tCount != 0 && hi < s.length()) {
                char hiC = s.charAt(hi);
                if (inT.contains(hiC)) {
                    count[hiC] -= 1;
                    if (count[hiC] >= 0) {
                        tCount -= 1;
                    }
                }
                hi++;
            }
                
            if (tCount == 0 && hi - i < resHi - resIdx) {
                // System.out.println("i: " + i + ", hi: " + hi);
                resIdx = i;
                resHi = hi;
            }
        }
        
        
        return resIdx == -1 ? "" : s.substring(resIdx, resHi);
    }
}