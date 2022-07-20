class Solution
{
    public int numMatchingSubseq(String s, String[] words)
    {
        int res = 0;
        List<ArrayDeque<Pair>> heads = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            heads.add(new ArrayDeque<Pair>());
        
        for (String w : words)
            heads.get(w.charAt(0) - 'a').offer(new Pair(w, 0));
        
        for (char c : s.toCharArray())
        {
            // Get the list for this character
            ArrayDeque<Pair> cHeads = heads.get(c - 'a');
            
            // Need to grab this ahead of time, list
            // could have items added to it.
            int initialSize = cHeads.size();
            for (int i = 0; i < initialSize; i++)
            {
                Pair p = cHeads.poll();
                p.index += 1;
                if (p.index == p.word.length())
                    res++;
                else
                    heads.get(p.word.charAt(p.index) - 'a').offer(p);
            }
        }
        
        return res;
    }
}

class Pair
{
    String word;
    int index;
    
    public Pair(String w, int i)
    {
        this.word = w;
        this.index = i;
    }
}