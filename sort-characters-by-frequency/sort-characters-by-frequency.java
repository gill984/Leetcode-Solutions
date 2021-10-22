class Solution {
    public String frequencySort(String s) {
        Tuple[] counts = new Tuple[128];
        for (char c : s.toCharArray())
        {
            if (counts[c] == null)
                counts[c] = new Tuple(c, 1);
            else
                counts[c].count++;
        }
        
        // Descending character counts
        Arrays.sort(counts, new Comparator<>() {
            public int compare(Tuple a, Tuple b)
            {
                if (a == null && b == null)
                    return 0;
                else if (a == null)
                    return 1;
                else if (b == null)
                    return -1;
                else
                    return b.count - a.count;
            }
        });
        
        
        StringBuilder res = new StringBuilder();
        for (Tuple t : counts)
            for (int i = 0; t != null && i < t.count; i++)
                res.append(t.c);
        
        return res.toString();
    }
    
    class Tuple
    {
        public int count;
        public char c;
        
        public Tuple (char c, int count)
        {
            this.c = c;
            this.count = count;
        }
    }
}