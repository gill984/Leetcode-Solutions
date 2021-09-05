class Solution {
    int m;
    int n;
    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        
        for (int i = m - 1; i >= 0; i--)
        {
            int j = 0;
            sortDiagonal(mat, i, j);
            while (i == 0 && ++j < n)
            {
                sortDiagonal(mat, i, j);
            }
        }
        
        return mat;
    }
    
    public void sortDiagonal(int[][] mat, int row, int col)
    {
        List<Integer> d = new ArrayList<Integer>();
        for (int i = row, j = col; i < m && j < n; i++, j++)
                d.add(mat[i][j]);
        
        Collections.sort(d);
        int idx = 0;
        for (int i = row, j = col; i < m && j < n; i++, j++)
                mat[i][j] = d.get(idx++);
    }
}