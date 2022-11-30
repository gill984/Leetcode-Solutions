class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int [] count = new int [2001];
        boolean [] occ = new boolean[1001];
        for (int i : arr) {
            count[i + 1000] += 1;
        }
        
        for (int i : count) {
            if (i == 0) {
                continue;
            }
            
            if (occ[i]) {
                return false;
            } else {
                occ[i] = true;
            }
        }
        
        return true;
    }
}