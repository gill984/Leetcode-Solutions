class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int [] indices = new int [n];
        for (int i = 0; i < n; i++) {
            heap.offer(new int [] {matrix[i][0], i});
        }
        
        int [] val = null;
        for (int i = 0; i < k; i++) {
            val = heap.poll();
            int row = val[1];
            indices[row] += 1;
            if (indices[row] < n) {
                heap.offer(new int [] {matrix[row][indices[row]], row});
            }
        }
        
        return val[0];
    }
}