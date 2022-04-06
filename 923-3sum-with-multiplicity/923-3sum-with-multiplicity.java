class Solution {
    public int threeSumMulti(int[] arr, int target) {
        // Order of the original array doesn't affect the tuple count
        long MOD = 1000000007;
        long [] count = new long [101];
        for (int i : arr)
            count[i]++;
        
        long res = 0;
        
        for (int i = 0; i <= 100; i++)
        {
            for (int j = i + 1; j <= 100; j++)
            {
                int k = target - i - j;
                if (j < k && k <= 100)
                {
                    res += count[i] * count[j] * count[k];
                    res %= MOD;
                }
            }
        }
        
        for (int i = 0; i <= 100; i++)
        {
            int j = target - (i * 2);
            if (i < j && j <= 100)
            {
                res += count[i] * (count[i] - 1) / 2 * count[j];
                res %= MOD;
            }
        }
        
        for (int x = 0; x <= 100; ++x) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    res += count[x] * count[y] * (count[y] - 1) / 2;
                    res %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                res += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                res %= MOD;
            }
        }
        
        return (int) res;
    }
}