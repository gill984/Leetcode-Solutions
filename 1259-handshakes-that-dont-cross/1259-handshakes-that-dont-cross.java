class Solution {
    public int numberOfWays(int num_people) {
        long M = 1_000_000_007;
        long[] cache = new long[num_people+1];
        cache[0] = 1;
        for (int i = 2; i <= num_people; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                cache[i] = (cache[i] + (cache[j-2]*cache[i-j])) % M;
            }
        }
        return (int)cache[num_people];
    }
}