class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] result = new int [m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = nextState(board, row, col);
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = result[row][col];
            }
        }
    }
    
    public int nextState(int[][] board, int row, int col) {
        int nbrs = numNeighbors(board, row, col);
        if (board[row][col] == 0)
        {
            if (nbrs == 3)
                return 1;
            else
                return 0;
        }
        else
        {
            if (nbrs == 2 || nbrs == 3)
                return 1;
            else
                return 0;
        }
    }
    
    public int numNeighbors (int [][] board, int row, int col)
    {
        int res = 0;
        for (int rd = -1; rd <= 1; rd++) {
            for (int cd = -1; cd <= 1; cd++) {
                // Skip same cell check
                if (rd == 0 && cd == 0)
                    continue;
                
                if (row + rd >= 0 && row + rd < board.length &&
                    col + cd >= 0 && col + cd < board[0].length &&
                    board[row + rd][col + cd] == 1)
                {
                    res++;
                }
            }
        }
        
        return res;
    }
}