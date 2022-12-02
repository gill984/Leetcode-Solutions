class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Each word must have the same set of characters
        // the two word's character counts must be the same while ignoring the char values
        Set<Character> chars = new HashSet<>();
        int [] count1 = new int [128];
        int [] count2 = new int [128];
        for (char c : word1.toCharArray()) {
            chars.add(c);
            count1[c]++;
        }
        
        for (char c : word2.toCharArray()) {
            if (!chars.contains(c)) {
                return false;
            }
            count2[c]++;
        }
        
        List<Integer> countList1 = new ArrayList<>();
        List<Integer> countList2 = new ArrayList<>();
        for (int i : count1)
            if (i != 0)
                countList1.add(i);
        for (int i : count2)
            if (i != 0)
                countList2.add(i);
        
        Collections.sort(countList1);
        Collections.sort(countList2);
        
        return countList1.equals(countList2);
    }
}