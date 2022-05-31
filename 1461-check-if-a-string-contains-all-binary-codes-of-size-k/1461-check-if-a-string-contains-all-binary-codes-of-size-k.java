class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Sliding window, shift bits out.
        // k <= 20 so we should be able to do this.
        // Put the entries in a hashset
        
        // Initialize things
        int n = s.length();
        int curr = 0;
        int MASK = (1 << k) - 1;
        for (int i = 0; i < k && i < n; i++) {
            curr <<= 1;
            curr += s.charAt(i) - '0';
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(curr);
        
        for (int i = k; i < n; i++) {
            curr <<= 1;
            curr += s.charAt(i) - '0';
            curr &= MASK;
            visited.add(curr);
        }       
        return (visited.size() == (1 << k));
    }
}