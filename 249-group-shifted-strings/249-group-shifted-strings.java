class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> buckets = new HashMap<>();
        for (String s : strings)
        {
            String translated = translate(s);
            buckets.putIfAbsent(translated, new ArrayList<String>());
            buckets.get(translated).add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String t : buckets.keySet())
            res.add(buckets.get(t));
        
        return res;
    }
    
    public String translate (String s)
    {
        // Manipulate this string so that it starts with a
        // shift all other letters to match
        int shift = 'a' - s.charAt(0);
        StringBuilder out = new StringBuilder();
        
        for (char c : s.toCharArray())
            out.append((char) (Math.floorMod(c - 'a' + shift, 26) + 'a'));
        
        return out.toString();
    }
}