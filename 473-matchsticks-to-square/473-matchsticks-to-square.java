class Solution {
    public boolean makesquare(int[] matchsticks) {
        int length = 0;
        for (int i : matchsticks)
            length += i;
        if (length % 4 != 0)
            return false;
        
        length /= 4;    // length of each side
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int n = matchsticks.length;
        return search(matchsticks, 0, new int [4], length, n);
    }
    
    boolean search (int [] matchsticks, int i, int[] sides, int length, int n) {
        if (i == n) {
            if (sides[0] == length && sides[1] == length && sides[2] == length)
                return true;
            return false;
        }
        
        // Try putting this match in each spot
        for (int s = 0; s < 4; s++) {
            if (sides[s] + matchsticks[i] > length)
                continue;
            sides[s] += matchsticks[i];
            if (search(matchsticks, i + 1, sides, length, n))
                return true;
            sides[s] -= matchsticks[i];
        }
        
        return false;
    }
    
    void reverse (int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int temp = a[lo];
            a[lo] = a[hi];
            a[hi] = temp;
            hi--;
            lo++;
        }
    }
}