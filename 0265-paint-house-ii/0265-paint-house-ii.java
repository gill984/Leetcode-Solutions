class Solution {
    int COLOR = 0;
    int COST = 1;
    
    public int minCostII(int[][] costs) {
        // dp[i][j] = min cost if all houses before house i are painted and i is painted color j
        // dp[i][j] = costs[i][j] + Math.min(dp[i-1][0:k]), can just store the minimum 2 colors used
        // per column. Need both because 1 in each row won't allow for painting the minimum.
        int n = costs.length;
        int k = costs[0].length;
        int [][] dp = new int [n][k];
        MinTracker bestPairs = new MinTracker();
        
        // Initialize using column 0
        for (int j = 0; j < k; j++) {
            bestPairs.addPair(j, costs[0][j]);
        }
        
        for (int house = 1; house < n; house++) {
            int [] secondBest = bestPairs.queue.poll();
            int [] best = bestPairs.queue.poll();
            
            for (int color = 0; color < k; color++) {
                int cost = (best[COLOR] == color ? secondBest[COST] : best[COST]) + costs[house][color];
                bestPairs.addPair(color, cost);
            }
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