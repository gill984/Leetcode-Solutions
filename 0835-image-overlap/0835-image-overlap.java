class Solution {
    int [][] dirs = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestOverlap(int[][] img1, int[][] img2) {
        // Try everything since n <= 30
        // up, down, left, and right n by n pixels
        int n = img1.length;
        
        // Move the top left (0, 0) pixel to every pixel in the square
        // as well as all the way to (-n, -n) out of the square
        int res = 0;
        for (int iOffset = -n; iOffset < n; iOffset++) {
            for (int jOffset = -n; jOffset < n; jOffset++) {
                int curr = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i + iOffset < n && i + iOffset >= 0 && j + jOffset < n && j + jOffset >= 0) {
                            if (img1[i + iOffset][j + jOffset] == 1 && img2[i][j] == 1) {
                                curr++;
                            }
                        }
                    }
                }
                
                res = Math.max(curr, res);
            }
        }
        
        return res;
    }
}