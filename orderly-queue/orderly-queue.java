class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1)
        {
            String best = s;
            for (int i = 0; i < s.length(); i++)
            {
                String attempt = s.substring(i, s.length()) + s.substring(0, i);
                if (attempt.compareTo(best) < 0)
                    best = attempt;
            }
            return best;
        }
        else
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}