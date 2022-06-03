class NumMatrix {

    int N;
    int M;
    int [][] leftSum;
    int [][] downSum;
    int [][] matrix;
    
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        M = matrix.length;
        N = matrix[0].length;
        leftSum = new int[M][N];
        
        for (int i = 0; i < M; i++)
        {
            int sum = 0;
            for (int j = 0; j < N; j++)
            {
                sum += matrix[i][j];
                leftSum[i][j] = sum;
            }
        }
        
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++)
            sum += leftSum[i][col2] - leftSum[i][col1] + matrix[i][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */