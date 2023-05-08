class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int sum = 0;
        
        for (int row = 0, col = 0; row < m && col < n; col++, row++) {
            int secondaryCol = (n - 1) - col;

            sum += mat[row][col];
            if (secondaryCol != col)
                sum += mat[row][secondaryCol];
        }
        
        return sum;
    }
}