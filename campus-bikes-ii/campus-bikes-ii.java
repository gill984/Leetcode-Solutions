class Solution {
    int min = Integer.MAX_VALUE;
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, new boolean [bikes.length], 0, 0);
        return min;
    }
    
    public int distance(int [] worker, int[] bike)
    {
        return (Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]));
    }
    
    public void dfs (int [][] workers, int [][] bikes, boolean [] usedBike, int curDistance, int curWorker)
    {
        if (curDistance >= min)
        {
            return;
        }
        
        if (curWorker == workers.length)
        {
            min = Math.min(min, curDistance);
            return;
        }
        
        // Try every bike
        for (int i = 0; i < bikes.length; i++)
        {
            if (usedBike[i])
                continue;
            
            int d = distance(workers[curWorker], bikes[i]);            
            usedBike[i] = true;
            dfs(workers, bikes, usedBike, curDistance + d, curWorker + 1);
            usedBike[i] = false;
        }
    }
}