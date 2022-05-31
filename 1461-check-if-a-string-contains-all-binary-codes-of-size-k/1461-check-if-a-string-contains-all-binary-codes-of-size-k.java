class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Sliding window, shift bits out.
        // k <= 20 so we should be able to do this.
        // Put the entries in a hashset
        
        // Initialize things
        int n = s.length();
        int curr = 0;
        int MASK = (1 << k) - 1;
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            curr = ((curr << 1) + (s.charAt(i) - '0')) & MASK;
            
            if (i >= k - 1)
                visited.add(curr);
        }    
        
        // System.out.println(visited);
        return (visited.size() == (1 << k));
    }
}