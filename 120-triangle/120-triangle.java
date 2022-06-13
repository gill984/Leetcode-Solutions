class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int left = (j > 0) ? triangle.get(i - 1).get(j - 1) : Integer.MAX_VALUE;
                int right = (j < row.size() - 1) ? triangle.get(i - 1).get(j) : Integer.MAX_VALUE;
                row.set(j, row.get(j) + Math.min(left, right));
            }
        }
        
        int res = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            res = Math.min(res, lastRow.get(i));
        }
        return res;
    }
}