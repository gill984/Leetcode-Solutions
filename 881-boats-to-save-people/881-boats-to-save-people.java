class Solution {
    public int numRescueBoats(int[] people, int limit) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int p : people)
        {
            set.add(p);
            counts.put(p, counts.getOrDefault(p, 0) + 1);
        }
            
        int res = 0;
        while (!set.isEmpty())
        {
            res++;
            int curr = set.last();
            counts.put(curr, counts.get(curr) - 1);
            if (counts.get(curr) == 0)
                set.remove(curr);
            
            int max = limit - curr;
            int choice = set.floor(max) != null ? set.floor(max) : -1;
            if (choice != -1)
            {
                counts.put(choice, counts.get(choice) - 1);
                if (counts.get(choice) == 0)
                    set.remove(choice);
            }
        }
        
        return res;
    }
}