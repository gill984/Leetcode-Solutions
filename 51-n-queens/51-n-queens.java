class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            dfs(0, i, new ArrayList<String>(), new boolean [n], new boolean [2 * n + 1], new boolean [2 * n + 1], n, res);
        return res;
    }
    
    // Keep track of rows, columns and diagonals
    public void dfs (int row, int col, List<String> curr, boolean [] usedCols, boolean [] usedDiagDown, boolean [] usedDiagUp, int n, List<List<String>> res) {
        if (usedCols[col] || usedDiagDown[diagDown(row, col, n)] || usedDiagUp[diagUp(row, col)]) {
            return;
        }
        
        curr.add(createQueenRow(col, n));        
        if (row == n - 1) {
            res.add(new ArrayList<String>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        
        usedCols[col] = true;
        usedDiagDown[diagDown(row, col, n)] = true;
        usedDiagUp[diagUp(row, col)] = true;
        
        // Can move to the next row
        for (int c = 0; c < n; c++) {
            dfs (row + 1, c, curr, usedCols, usedDiagDown, usedDiagUp, n, res);
        }
        
        curr.remove(curr.size() - 1);
        usedCols[col] = false;
        usedDiagDown[diagDown(row, col, n)] = false;
        usedDiagUp[diagUp(row, col)] = false;
    }
    
    private String createQueenRow(int col, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(i == col ? 'Q' : '.');
        return res.toString();
    }
    
    private int diagDown(int row, int col, int n) {
        return (n - 1 - row) + col;
    }
    
    private int diagUp(int row, int col) {
        return row + col;
    }
}