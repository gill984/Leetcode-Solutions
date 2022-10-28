class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<WordMap, ArrayList<String>> map = new HashMap<WordMap, ArrayList<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(String s : strs)
        {
            WordMap w = new WordMap(s);
            
            if(map.containsKey(w))
            {
                map.get(w).add(s);
            }
            else
            {
                ArrayList<String> l = new ArrayList<String>();
                res.add(l);
                l.add(s);
                map.put(w, l);
            }
        }
            
        // System.out.println(map);

        // for(WordMap i : map.keySet())
        // {
        //     res.add(map.get(i));
        // }
        
        return res;
    }
}

class WordMap
{
    int [] occ;
    String s;
    
    public WordMap(String s)
    {
        this.s = s;
        occ = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            occ[s.charAt(i) - 'a'] += 1;
        }
    }
    
    public boolean equals(Object o)
    {
        WordMap wm = (WordMap)o;
        return Arrays.equals(this.occ, wm.occ);
    }
    
    public boolean isAnagram(WordMap wm)
    {
        for(int i = 0; i < occ.length; i++)
        {
            if(wm.occ[i] != this.occ[i])
                return false;
        }
        
        return true;
    }
    
    public int hashCode()
    {
        return Arrays.hashCode(occ);
    }
}