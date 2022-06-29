class Solution {
    private final int HEIGHT = 0;
    private final int TALLER = 1;
    private final int EMPTY = -1;
    
    public int[][] reconstructQueue(int[][] people) {
        // O1: If sorted, the shortest group of people can all be directly inserted into the array.
        //     However many people are taller than or equal in height is how many indices they are back
        //     from the front of the line.
        // O2: For each successively taller group, can iterate from front to back (l to r) in the current line and determine
        //     how many spots they need to go back to fit in. Subtract from k as we go until k is 0 using the rules below:
        //         If the index currently contains a  person, then don't subtract from k
        //         If the index is empty, subtract 1 from k
        //     Until k == 0
        
        if(people == null || people.length == 0)
            return new int[0][0];
        
        int [][] res = new int [people.length][people[0].length];
        for(int i = 0; i < res.length; i++)
            Arrays.fill(res[i], EMPTY);
        
        // Generate priorityqueue which sorts elements in the way stated above
        PriorityQueue<int[]> pq =
            new PriorityQueue<int[]>(people.length,
                (int[] p1, int[] p2) -> p1[HEIGHT] == p2[HEIGHT] ? p2[TALLER] - p1[TALLER] : p1[HEIGHT] - p2[HEIGHT]);
        for(int i = 0; i < people.length; i++)
            pq.offer(people[i]);
        
        // Perform algorithm stated by O1 and O2 above
        while(!pq.isEmpty())
        {
            int[] p = pq.poll();
            int k = p[TALLER];
            for(int i = 0; i < res.length; i++)
            {
                if(k == 0)
                {
                    if(res[i][HEIGHT] == EMPTY)
                    {
                        // Found the spot
                        res[i][HEIGHT] = p[HEIGHT];
                        res[i][TALLER] = p[TALLER];
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
                else if(res[i][HEIGHT] == EMPTY)
                {
                    k--;
                }
                else
                {
                    continue;
                }
            }
        }
        
        return res;
    }
}