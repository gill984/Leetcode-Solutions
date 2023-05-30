class TicTacToe {
    int [] rowCounts;
    int [] colCounts;
    int diag;
    int antiDiag;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rowCounts = new int [n];
        colCounts = new int [n];
    }
    
    public int move(int row, int col, int player) {
        int change = player == 1 ? 1 : -1;
        rowCounts[row] += change;
        colCounts[col] += change;
        if (row == col)
            diag += change;
        if (row + col + 1 == n)
            antiDiag += change;
        
        if (Math.abs(rowCounts[row]) == n || 
            Math.abs(colCounts[col]) == n || 
            Math.abs(diag) == n || 
            Math.abs(antiDiag) == n)
            return player;
        
        return 0;
    }
}