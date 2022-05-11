class Solution {
    int MAX = 5;
    
    public int countVowelStrings(int n) {
        return dfs (n, 1, 0);
    }
    
    public int dfs (int n, int min, int length) {
        if (length == n) {
            return 1;
        }
        
        int sum = 0;
        for (int i = min; i <= MAX; i++) {
            sum += dfs (n, i, length + 1);
        }
        
        return sum;
    }
}