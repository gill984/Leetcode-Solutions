class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int hi = n - 1;
        int lo = 0;
        int res = 0;
        
        while (hi >= lo) {
            if (people[hi] + people[lo] <= limit)
                lo++;
            hi--;
            res += 1;
        }
        
        return res;
    }
}