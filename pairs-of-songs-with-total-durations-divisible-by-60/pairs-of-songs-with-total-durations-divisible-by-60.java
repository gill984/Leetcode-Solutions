class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // Can mod all numbers by 60 wlog
        int [] count = new int[60];
        for (int i = 0; i < time.length; i++)
            count[time[i] % 60] += 1;
        
        int result = 0;
        if(count[0] > 0)
            result += (count[0] * (count[0] - 1)) / 2;
        if(count[30] > 0)
            result += (count[30] * (count[30] - 1)) / 2;
        
        for (int i = 1; i < 30; i++)
            result += count[i] * count[60 - i];
        
        return result;
    }
}