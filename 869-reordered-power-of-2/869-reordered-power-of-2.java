class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<String> powers = new ArrayList<>();
        List<Map<Character, Integer>> counts = new ArrayList<>();
        
        for (int pow = 1; ; pow *= 2) {
            powers.add("" + pow);
            
            if (pow == 1 << 30)
                break;
        }
        
        // Create the counts
        for (String p : powers) {
            Map<Character, Integer> count = new HashMap<>();
            for (char c : p.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            counts.add(count);
        }
        
        String ns = "" + n;
        Map<Character, Integer> nCount = new HashMap<>();
        for (char c : ns.toCharArray()) {
            nCount.put(c, nCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map<Character, Integer> power : counts)
            if (power.equals(nCount))
                return true;
        
        return false;
    }
}