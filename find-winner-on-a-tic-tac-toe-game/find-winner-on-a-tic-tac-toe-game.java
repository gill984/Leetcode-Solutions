class Solution {
    public String tictactoe(int[][] moves) {
        int m = 3;
        int n = 3;
        int [][] board = new int [m][n];
        
        int player = 1;
        for (int[] move : moves)
        {
            board[move[0]][move[1]] = player;
            player = -player;
        }
        
        // Check rows, columns, and diagonal
        int winner = 0;
        for (int row = 0; row < m; row++)
        {
            if (board[row][0] != 0 && board[row][0] == board[row][1] &&
               board[row][0] == board[row][2])
            {
                winner = board[row][0];
            }
        }
        
        for (int col = 0; col < n; col++)
        {
            if (board[0][col] != 0 && board[0][col] == board[1][col] &&
               board[0][col] == board[2][col])
            {
                winner = board[0][col];
            }
        }
        
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            winner = board[0][0];
        
        if (board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2])
            winner = board[2][0];
        
        if (winner == 1)
            return "A";
        else if (winner == -1)
            return "B";
        else if (moves.length < 9)
            return "Pending";
        else
            return "Draw";
    }
}