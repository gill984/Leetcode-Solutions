class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int [][] left = new int [n][3];
        int [][] right = new int [n][3];
        
        for (int i = 0; i < 3; i++) {
            left[0][i] = 1000000;
            right[n - 1][i] = 1000000;
        }
        
        left[0][colors[0] - 1] = 0;
        right[n - 1][colors[n - 1] - 1] = 0;
        
        for (int i = 1; i < n; i++) {
            int c = colors[i];
            left[i][0] = (c == 1 ? 0 : left[i - 1][0] + 1);
            left[i][1] = (c == 2 ? 0 : left[i - 1][1] + 1);
            left[i][2] = (c == 3 ? 0 : left[i - 1][2] + 1);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int c = colors[i];
            right[i][0] = (c == 1 ? 0 : right[i + 1][0] + 1);
            right[i][1] = (c == 2 ? 0 : right[i + 1][1] + 1);
            right[i][2] = (c == 3 ? 0 : right[i + 1][2] + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int [] query : queries) {
            int idx = query[0];
            int c = query[1] - 1;
            int distance = Math.min(left[idx][c], right[idx][c]);
            if (distance >= 1000000) {
                distance = -1;
            }
            res.add(distance);
        }
        
        return res;
    }
}