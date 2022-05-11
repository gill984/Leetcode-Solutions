class Solution {
    int MAX = 5;
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int countVowelStrings(int n) {
        return dfs (n, 1, 0);
    }
    
    public int dfs (int n, int min, int length) {
        int key = min + (MAX + 1) * (n - length);
        if (length == n) {
            memo.put(key, 1);
            return 1;
        } 
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int sum = 0;
        for (int i = min; i <= MAX; i++) {
            sum += dfs (n, i, length + 1);
        }
        
        memo.put(key, sum);
        return sum;
    }
}