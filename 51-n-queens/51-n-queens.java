class Solution {
    int n;
    int usedCols = 0, usedDiagDown = 0, usedDiagUp = 0;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<String>> res = new ArrayList<>();
        dfs(0, new ArrayList<String>(), res);
        return res;
    }
    
    public void dfs (int row, List<String> board, List<List<String>> res) {
        for (int col = 0; col < n; col++) {
            if (isUsed(row, col))
                continue;
                
            board.add(createQueenRow(col, n));
            flipUseBits(row, col);

            if (row == n - 1)
                res.add(new ArrayList<String>(board));
            else
                dfs (row + 1, board, res);

            board.remove(board.size() - 1);
            flipUseBits(row, col);
        }
    }
    
    private boolean isUsed (int row, int col) {
        return (usedCols & (1 << col)) != 0 || (usedDiagDown & (1 << (n - 1 - row + col))) != 0 || (usedDiagUp & (1 << (row + col))) != 0;
    }
    
    private void flipUseBits (int row, int col) {
        usedCols ^= (1 << col);
        usedDiagDown ^= (1 << (n - 1 - row + col));
        usedDiagUp ^= (1 << (row + col));
    }
    
    private String createQueenRow(int col, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(i == col ? 'Q' : '.');
        return res.toString();
    }
}