class Solution {
    public int minJumps(int[] arr) {
        // BFS on the graph
        // Map each value in array to list of indices where that value occurs
        // Can go to 1 before, 1 after, or anywhere in the list
        int n = arr.length;
        
        // Build hashmap of neighbor nodes
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int i = n - 1; i >= 0; i--)
        {
            
            neighbors.putIfAbsent(arr[i], new ArrayList<Integer>());
            neighbors.get(arr[i]).add(i);
        }
        
        // Perform BFS
        Queue<int[]> bfsQueue = new ArrayDeque<>();
        int [] start = new int [] {0, 0};
        bfsQueue.offer(start);
        Set<Integer> visited = new HashSet<>();
        
        while (!bfsQueue.isEmpty())
        {
            int [] state = bfsQueue.poll();
            int index = state[0];
            int jumps = state[1];
            
            visited.add(index);
            
            if (index == n - 1)
            {
                return jumps;
            }
            
            // Put all other possibilities onto the queue
            if (index - 1 >= 0 && !visited.contains(index - 1))
            {
                bfsQueue.offer(new int [] {index - 1, jumps + 1});
                visited.add(index - 1);
            }
            
            if (index + 1 < n && !visited.contains(index + 1))
            {
                bfsQueue.offer(new int [] {index + 1, jumps + 1});
                visited.add(index + 1);
            }

            if (neighbors.containsKey(arr[index]))
            {
                for (int nbr : neighbors.get(arr[index]))
                {
                    if (nbr != index && !visited.contains(nbr))
                    {
                        bfsQueue.offer(new int [] {nbr, jumps + 1});
                        visited.add(nbr);
                    }
                }
            }
            
            neighbors.get(arr[index]).clear();
        }
        
        return -1;
    }
}