class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, new ArrayList<String>(), new boolean [n], new boolean [2 * n + 1], new boolean [2 * n + 1], n, res);
        return res;
    }
    
    // Keep track of rows, columns and diagonals
    public void dfs (int row, List<String> curr, boolean [] usedCols, boolean [] usedDiagDown, boolean [] usedDiagUp, int n, List<List<String>> res) {
        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedDiagDown[(n - 1 - row) + col] || usedDiagUp[row + col])
                continue;
                
            curr.add(createQueenRow(col, n));        
            if (row == n - 1) {
                res.add(new ArrayList<String>(curr));
                curr.remove(curr.size() - 1);
                continue;
            }

            usedCols[col] = true;
            usedDiagDown[(n - 1 - row) + col] = true;
            usedDiagUp[row + col] = true;

            // Can move to the next row
            dfs (row + 1, curr, usedCols, usedDiagDown, usedDiagUp, n, res);

            curr.remove(curr.size() - 1);
            usedCols[col] = false;
            usedDiagDown[(n - 1 - row) + col] = false;
            usedDiagUp[row + col] = false;
        }
    }
    
    private String createQueenRow(int col, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(i == col ? 'Q' : '.');
        return res.toString();
    }
}