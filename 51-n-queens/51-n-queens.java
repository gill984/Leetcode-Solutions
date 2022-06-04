class Solution {
    int n;
    boolean [] usedCols;
    boolean [] usedDiagDown;
    boolean [] usedDiagUp;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<String>> res = new ArrayList<>();
        usedCols = new boolean[n];
        usedDiagDown = new boolean[2 * n + 1];
        usedDiagUp = new boolean [2 * n + 1];
        dfs(0, new ArrayList<String>(), res);
        return res;
    }
    
    public void dfs (int row, List<String> curr, List<List<String>> res) {
        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedDiagDown[(n - 1 - row) + col] || usedDiagUp[row + col])
                continue;
                
            curr.add(createQueenRow(col, n));
            used(true, row, col);

            if (row == n - 1)
                res.add(new ArrayList<String>(curr));
            else
                dfs (row + 1, curr, res);

            curr.remove(curr.size() - 1);
            used(false, row, col);
        }
    }
    
    private void used (boolean use, int row, int col) {
        usedCols[col] = use;
        usedDiagDown[(n - 1 - row) + col] = use;
        usedDiagUp[row + col] = use;
    }
    
    private String createQueenRow(int col, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(i == col ? 'Q' : '.');
        return res.toString();
    }
}