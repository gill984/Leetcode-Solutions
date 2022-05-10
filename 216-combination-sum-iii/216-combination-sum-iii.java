class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs (k, n, 0, new ArrayList<>(), 0, res);
        return res;
    }
    
    public void dfs (int k, int n, int sum, List<Integer> curr, int min, List<List<Integer>> res) {
        if (k == curr.size() && n == sum) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (curr.size() >= k) {
            return;
        }
        
        // Have to start at min or larger
        for (int i = min + 1; i <= 9 && i + sum <= n; i++) {
            curr.add(i);
            dfs (k, n, sum + i, curr, i, res);
            curr.remove(curr.size() - 1);
        }
    }
}