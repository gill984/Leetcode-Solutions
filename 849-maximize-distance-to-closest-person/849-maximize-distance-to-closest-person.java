class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int [] closest = new int [n];
        
        // From the left, put the closest seat distance in
        int curr = -1;
        for (int i = 0; i < n; i++)
        {
            if (seats[i] == 0)
            {
                if (curr == -1)
                {
                    closest[i] = Integer.MAX_VALUE;
                }
                else
                {
                    closest[i] = i - curr;
                }
            }
            else
            {
                closest[i] = 0;
                curr = i;
            }
        }
        
        System.out.println(Arrays.toString(closest));
        
        // From the right, put the closest distance in
        curr = -1;
        for (int i = n - 1; i >= 0; i--)
        {
            if (seats[i] == 0)
            {
                if (curr == -1)
                {
                    closest[i] = Math.min(closest[i], Integer.MAX_VALUE);
                }
                else
                {
                    closest[i] = Math.min(closest[i], curr - i);
                }
            }
            else
            {
                closest[i] = 0;
                curr = i;
            }
        }
        
        int max = 0;
        for (int i : closest)
        {
            max = Math.max(max, i);
        }
        
        System.out.println(Arrays.toString(closest));
        
        return max;
    }
}