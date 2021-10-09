class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int [] as = new int [] {a, (int) 'a'};
        int [] bs = new int [] {b, (int) 'b'};
        int [] cs = new int [] {c, (int) 'c'};
        
        // Max pq
        PriorityQueue<int[]> pq = new PriorityQueue<>(3, (x, y) -> y[0] - x[0]);
        
        if (a > 0)
            pq.offer(as);
        
        if (b > 0)
            pq.offer(bs);
        
        if (c > 0)
            pq.offer(cs);
        
        while (!pq.isEmpty())
        {
            int [] first = pq.poll();
            // Try most frequent, can add if previous 2 entries aren't the same char
            if (res.length() < 2 || res.charAt(res.length() - 1) != first[1] || res.charAt(res.length() - 2) != first[1])
            {
                first[0] -= 1;
                res.append((char) first[1]);
                if (first[0] > 0)
                    pq.offer(first);
            }
            else
            {
                // Try second most frequent, if pq is empty, no more chars can be added
                int [] second = null;
                if (!pq.isEmpty())
                    second = pq.poll();
                else
                    break;
                
                second[0] -= 1;
                res.append((char) second[1]);
                if (second[0] > 0)
                    pq.offer(second);
                pq.offer(first);
            }
        }
        
        return res.toString();
    }
}