class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // Go through all the different submatrices and check if they equal target
        // Cache the matrix sums referenced by topleft cell and bottom right cell inclusive
        // dp[i][j] = sum of matrix from top left cell it cell [i][j]
        
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int [m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 
                    (i > 0 ? dp[i - 1][j] : 0) 
                    + (j > 0 ? dp[i][j - 1] : 0) 
                    - (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) 
                    + matrix[i][j];
            }
        }
        
        int res = 0;
        // Iterate through all possible matrices
        for (int tr = 0; tr < m; tr++) {
            for (int lc = 0; lc < n; lc++) {
                for (int br = tr; br < m; br++) {
                    for (int rc = lc; rc < n; rc++) {
                        int val = dp[br][rc] 
                            - (lc > 0 ? dp[br][lc - 1] : 0) 
                            - (tr > 0 ? dp[tr - 1][rc] : 0) 
                            + (tr > 0 && lc > 0 ? dp[tr - 1][lc - 1] : 0);
                        
                        if (val == target)
                            res++;
                    }
                }
            }
        }
        
        return res;
    }
}