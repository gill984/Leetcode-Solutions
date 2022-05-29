class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // Topological sort on the dependency graph
        Node [] nodes = new Node[n + 1];
        
        for (int i = 1; i < n + 1; i++)
            nodes[i] = new Node();
        
        for (int i = 0; i < relations.length; i++) {
            int preReq = relations[i][0];
            int postReq = relations[i][1];
            nodes[preReq].postReqs.add(postReq);
            nodes[postReq].inDegree++;
        }
        
        // Perform topological sort
        int visited = 0;
        int semesters = 0;
        ArrayDeque<Integer> next = new ArrayDeque<>();
        
        for (int i = 1; i < n + 1; i++)
            if (nodes[i].inDegree == 0)
                next.offer(i);
        
        while (!next.isEmpty()) {
            semesters++;
            ArrayDeque<Integer> curr = next;
            next = new ArrayDeque<>();
            
            while (!curr.isEmpty()) {
                int node = curr.poll();
                for (int nbr : nodes[node].postReqs) {
                    nodes[nbr].inDegree--;
                    if (nodes[nbr].inDegree == 0)
                        next.offer(nbr);
                }
                visited++;
            }
        }
        
        return visited == n ? semesters : -1;
    }
    
    class Node {
        int inDegree;
        List<Integer> postReqs;
        
        public Node () {
            inDegree = 0;
            postReqs = new ArrayList<>();
        }
    }
}