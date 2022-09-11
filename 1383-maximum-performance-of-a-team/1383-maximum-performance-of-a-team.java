class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int [][] engineers = new int [n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> bestSpeeds = new PriorityQueue<>();
        long sumSpeed = 0;
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            int s = engineers[i][0];
            int e = engineers[i][1];
            if (bestSpeeds.size() < k) {
                bestSpeeds.offer(s);
                sumSpeed += s;
            } else if (bestSpeeds.peek() < s) {
                sumSpeed -= bestSpeeds.poll();
                sumSpeed += s;
                bestSpeeds.offer(s);
            }
            res = Math.max(res, sumSpeed * e);
        }        
        
        return (int) (res % 1000000007);
    }
}