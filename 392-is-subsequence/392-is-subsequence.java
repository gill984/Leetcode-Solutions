class Solution {
    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length();)
        {
            if (s.charAt(i) == t.charAt(j))
            {
                i++;
                if (i == s.length())
                    return true;
            }
            j++;
        }
        return s.equals("");
    }
}