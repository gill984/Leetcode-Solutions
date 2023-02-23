class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < n; i++) {
            minCapital.offer(new int[] {profits[i], capital[i]});
        }
        
        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[1] <= w)
                maxProfit.offer(minCapital.poll());
            
            if (maxProfit.isEmpty())
                break;
            
            w += maxProfit.poll()[0];
        }
        
        return w;
    }
}