class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length())
        {
            if (s.charAt(i) == t.charAt(j))
            {
                i++;
                if (i == s.length())
                    break;
            }
            j++;
        }
        return i == s.length();
    }
}