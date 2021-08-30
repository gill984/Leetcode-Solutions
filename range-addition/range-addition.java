class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] res = new int [length];
        for (int [] update : updates)
        {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            
            res[start] += inc;
            if (end + 1 < length)
                res[end + 1] -= inc;
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++)
        {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }
}