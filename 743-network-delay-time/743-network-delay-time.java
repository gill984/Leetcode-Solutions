class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n + 1; i++)
            nodes[i] = new Node();
        
        for (int[] time : times) {
            nodes[time[0]].neighbors.add(new int [] {time[1], time[2]});
        }
        
        // Just run dijkstra pussy
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int [] {k, 0});
        Set<Integer> visited = new HashSet<>();
        
        while (!pq.isEmpty()) {
            
            int [] path = pq.poll();
            if (visited.contains(path[0])) {
                continue;
            }
            
            visited.add(path[0]);
            if (visited.size() == n) {
                return path[1];
            }
            
            for (int [] nbr : nodes[path[0]].neighbors) {
                pq.offer(new int [] {nbr[0], path[1] + nbr[1]});
            }
        }
        
        return -1;
    }
    
    class Node {
        List<int[]> neighbors;
        public Node () {
            neighbors = new ArrayList<>();
        }
    }
}