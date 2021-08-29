class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n == 0)
            return true;
        
        Map<Integer, Set<Integer>> stepsByDistance = new HashMap<Integer, Set<Integer>>();
        stepsByDistance.put(0, new HashSet<Integer>());
        stepsByDistance.get(0).add(1);
        for (int i = 1; i < n; i++)
            stepsByDistance.put(stones[i], new HashSet<Integer>());
        
        for (int s = 0; s < n - 1; s++)
        {
            int stone = stones[s];
            Set<Integer> steps = stepsByDistance.get(stone);
            for (int step : steps)
            {
                int reach = step + stone;
                if (reach == stones[n - 1])
                    return true;
                
                if (stepsByDistance.containsKey(reach))
                {
                    stepsByDistance.get(reach).add(step);
                    stepsByDistance.get(reach).add(step + 1);
                    if (step - 1 > 0)
                        stepsByDistance.get(reach).add(step - 1);
                }
            }
        }
        
        return false;
    }
}