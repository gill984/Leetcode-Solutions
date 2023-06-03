class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Build graph then traverse
        List<List<Integer>> graph = new ArrayList<>();
        int headNode = -1;
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1)
                headNode = i;
            else
                graph.get(manager[i]).add(i);
        }
        
        return dfsTime(headNode, graph, informTime, n);
    }
    
    public int dfsTime(int curr, List<List<Integer>> graph, int [] informTime, int n) {
        int max = 0;
        for (int nbr : graph.get(curr)) {
            max = Math.max(dfsTime(nbr, graph, informTime, n), max);
        }
        return max + informTime[curr];
    }
}