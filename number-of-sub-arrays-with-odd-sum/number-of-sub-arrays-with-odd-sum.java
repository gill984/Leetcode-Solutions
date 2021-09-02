class Solution {
    public int numOfSubarrays(int[] arr) {
        int o = (arr[0] % 2);
        int res = o;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] % 2 != 0)
                o = i - o + 1;
                res = (res + o) % 1000000007;
        }
        return res;
    }
}