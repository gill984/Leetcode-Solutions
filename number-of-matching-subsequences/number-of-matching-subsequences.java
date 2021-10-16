class Solution
{
    public int numMatchingSubseq(String s, String[] words)
    {
        int res = 0;
        List<List<Pair>> heads = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            heads.add(new ArrayList<Pair>());
        
        for (String w : words)
            heads.get(w.charAt(0) - 'a').add(new Pair(w, 0));
        
        for (char c : s.toCharArray())
        {
            // Get the list for this character
            List<Pair> cHeads = heads.get(c - 'a');
            
            // Need to do this in cases where 2 characters
            // in a row are the same, otherwise we add
            // back to the same bucket
            List<Pair> temp = new ArrayList<Pair>();
            
            for (Pair p : cHeads)
            {
                p.index += 1;
                if (p.index == p.word.length())
                    res++;
                else
                    temp.add(p);
            }
            
            cHeads.clear();
            for (Pair p : temp)
                heads.get(p.word.charAt(p.index) - 'a').add(p);
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