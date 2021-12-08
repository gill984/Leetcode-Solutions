class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1)
            return new int [] {};
        
        Arrays.sort(changed);
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> original = new ArrayList<>();
        
        for (int i : changed)
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        
        for (int idx = 0; idx < changed.length; idx++)
        {
            if (idx > 0 && changed[idx] == changed[idx - 1])
                continue;
            
            int i = changed[idx];
            System.out.println(i);
            
            if (counts.getOrDefault(i * 2, 0) >= counts.get(i))
            {
                int doubleCount = counts.getOrDefault(i * 2, 0);
                int singleCount = counts.getOrDefault(i, 0);
                
                if (i != 0)
                {
                    for (int j = 0; j < singleCount; j++)
                    {
                        original.add(i);
                    }
                }
                else
                {
                    if (singleCount % 2 == 1)
                        return new int [] {};
                    
                    for (int j = 0; j < singleCount / 2; j++)
                    {
                        original.add(i);
                    }
                }
                
                doubleCount -= singleCount;
                counts.put(i * 2, doubleCount);
            }
            else
            {
                return new int [] {};
            }
        }
        
        int [] res = new int [changed.length / 2];
        for (int i = 0; i < res.length; i++)
            res[i] = original.get(i);
        
        return res;
    }
}