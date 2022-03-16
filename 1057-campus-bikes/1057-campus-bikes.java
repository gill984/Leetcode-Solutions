class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // Bucket worker-bucket pairs
        // Only need 2000 buckets
        Map<Integer, PriorityQueue<int[]>> buckets = new HashMap<>();
        for (int i = 0; i < workers.length; i++)
        {
            for (int j = 0; j < bikes.length; j++)
            {
                int [] pair = new int [] {i, j};
                int d = distance(workers[i], bikes[j]);
                
                // Sort by worker index then by bike index if distances are equal
                buckets.putIfAbsent(d, new PriorityQueue<int[]>((a, b) -> a[0] - b[0] == 0 ? 
                                                                a[1] - b[1] : 
                                                                a[0] - b[0]));
                buckets.get(d).offer(pair);
            }
        }
        
        Set<Integer> visitedBikes = new HashSet<>();
        Set<Integer> visitedWorkers = new HashSet<>();
        int [] res = new int [workers.length];
        
        for (int i = 0; i < 2000 && visitedWorkers.size() < workers.length; i++)
        {
            if (!buckets.containsKey(i))
                continue;
                
            PriorityQueue<int[]> pairs = buckets.get(i);
            
            while (!pairs.isEmpty())
            {
                int [] pair = pairs.poll();
                if (!visitedWorkers.contains(pair[0]) && !visitedBikes.contains(pair[1]))
                {
                    visitedWorkers.add(pair[0]);
                    visitedBikes.add(pair[1]);
                    res[pair[0]] = pair[1];
                }
            }
        }
        
        return res;
    }
    
    public int distance (int [] worker, int [] bike)
    {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}