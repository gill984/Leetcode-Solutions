class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        
        int [][] dp = new int [m][n];
        dp [0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < row.size() - 1) ? dp[i - 1][j] : Integer.MAX_VALUE;
                dp[i][j] = row.get(j) + Math.min(left, right);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}