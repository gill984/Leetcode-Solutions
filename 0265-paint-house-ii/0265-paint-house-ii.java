class Solution {
    int COLOR = 0;
    int COST = 1;
    
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int [][] dp = new int [n][k];
        MinTracker bestPairs = new MinTracker();
        
        // Initialize using column 0
        for (int j = 0; j < k; j++)
            bestPairs.addPair(j, costs[0][j]);
        
        for (int house = 1; house < n; house++) {
            int [] secondBest = bestPairs.queue.poll();
            int [] best = bestPairs.queue.poll();
            for (int color = 0; color < k; color++)
                bestPairs.addPair(color, (best[COLOR] == color ? secondBest[COST] : best[COST]) + costs[house][color]);
        }
        
        if (bestPairs.queue.size() == 1)
            return bestPairs.queue.poll()[1];
        
        bestPairs.queue.poll();
        return bestPairs.queue.poll()[1];
    }
}

class MinTracker {
    PriorityQueue<int[]> queue;
    
    public MinTracker() {
        queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    }
    
    public void addPair(int color, int cost) {
        if (queue.size() < 2) {
            queue.offer(new int [] {color, cost});
        } else if (queue.peek()[1] > cost) {
            queue.poll();
            queue.offer(new int [] {color, cost});
        }
    }
}