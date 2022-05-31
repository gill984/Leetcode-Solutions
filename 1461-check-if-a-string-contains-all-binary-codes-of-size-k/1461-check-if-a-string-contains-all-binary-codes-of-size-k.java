class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int curr = 0;
        int MASK = (1 << k) - 1;
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < n && visited.size() < (1 << k); i++) {
            curr = ((curr << 1) + (s.charAt(i) - '0')) & MASK;
            if (i >= k - 1)
                visited.add(curr);
        }
        
        return (visited.size() == (1 << k));
    }
}