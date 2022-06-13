class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        
        int [] dp = new int [n];
        dp [0] = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int prev = Integer.MAX_VALUE;
            for (int j = 0; j < row.size(); j++) {
                int temp = dp[j];
                int left = (j > 0) ? prev : Integer.MAX_VALUE;
                int right = (j < row.size() - 1) ? dp[j] : Integer.MAX_VALUE;
                dp[j] = row.get(j) + Math.min(left, right);
                prev = temp;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, dp[i]);
        return res;
    }
}