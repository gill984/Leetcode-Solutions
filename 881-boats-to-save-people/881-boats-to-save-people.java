class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lo = 0;
        int hi = people.length - 1;
        int res = 0;
        
        while (hi >= lo)
        {
            res++;
            int heavy = people[hi];
            int light = people[lo];
            hi--;
            
            if (heavy + light <= limit)
            {
                lo++;
            }
        }
        
        return res;
    }
}