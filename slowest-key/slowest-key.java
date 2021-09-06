class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        
        char res = keys[0];
        int time = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++)
        {
            if (releaseTimes[i] - releaseTimes[i - 1] > time)
            {
                res = keys[i];
                time = releaseTimes[i] - releaseTimes[i - 1];
            }
            else if (releaseTimes[i] - releaseTimes[i - 1] == time && res < keys[i])
            {
                res = keys[i];
            }
        }
        
        return res;
    }
}