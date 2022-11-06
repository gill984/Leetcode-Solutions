class Solution {
    public String orderlyQueue(String s, int k) {
        if (k >= 2) {
            char [] letters = s.toCharArray();
            Arrays.sort(letters);
            return new String(letters);
        }
        
        int n = s.length();
        String doubled = s + s;
        String min = s;
        for (int i = 1; i < n; i++) {
            String candidate = doubled.substring(i, i + n);
            if (candidate.compareTo(min) < 0) {
                min = candidate;
            }
        }
        
        return min;
    }
}