class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Use bucket sort since from and to can only be [0, 1000]
        int [] passengers = new int [1001];
        
        for (int [] trip : trips)
        {
            passengers[trip[1]] += trip[0];
            passengers[trip[2]] -= trip[0];
        }
        
        // Now make sure the sum of passengers stays under capacity
        int neededCapacity = 0;
        for (int i : passengers)
        {
            neededCapacity += i;
            if (neededCapacity > capacity)
                return false;
        }
        
        return true;
    }
}