class Solution {
    int m;
    int n;
    public int[][] diagonalSort(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        
        for (int i = 0; i < m; i++)
            sortDiag(mat, i, 0);
        
        for (int i = 1; i < n; i++)
            sortDiag(mat, 0, i);
        
        return mat;
    }
    
    public void sortDiag(int[][] mat, int row, int col) {
        List<Integer> diag = new ArrayList<>();
        int tempRow = row;
        int tempCol = col;
        while (row < m && col < n) {
            diag.add(mat[row][col]);
            row++;
            col++;
        }
        
        Collections.sort(diag);
        for (int i : diag) {
            mat[tempRow][tempCol] = i;
            tempRow++;
            tempCol++;
        }
    }
}